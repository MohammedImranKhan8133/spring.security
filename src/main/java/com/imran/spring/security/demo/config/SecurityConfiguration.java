package com.imran.spring.security.demo.config;

import com.imran.spring.security.demo.Security.ApplicationUserRole;
import com.imran.spring.security.demo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/student/*").hasRole(ApplicationUserRole.USER.name())
                .anyRequest().authenticated().and().httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user=User.builder()
                .username("imran")
                .password(passwordEncoder().encode("user123"))
                .roles(ApplicationUserRole.USER.name()).build();

        UserDetails admin=User.builder()
                .username("jaffer")
                .password(passwordEncoder().encode("admin123"))
                .roles(ApplicationUserRole.ADMIN.name()).build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
