package com.imran.spring.security.demo.config;

import com.imran.spring.security.demo.Security.ApplicationUserRole;
import com.imran.spring.security.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private Test test;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/student/*")
                .hasRole(test.getRoleUser())
                .antMatchers(HttpMethod.POST,"/test/api/put").hasAuthority(test.getRoleUser())
                //.hasRole(ApplicationUserRole.USER.name())
                .anyRequest().authenticated().and().formLogin();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user=User.builder()
                .username("imran")
                .password(passwordEncoder().encode("user123"))
                .roles(test.setRoleUser("user")).build();
                //.roles(ApplicationUserRole.USER.name()).build();

        UserDetails admin=User.builder()
                .username("jaffer")
                .password(passwordEncoder().encode("admin123"))
                .roles(test.setRoleAdmin("admin")).build();
                //.roles(ApplicationUserRole.ADMIN.name()).build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
