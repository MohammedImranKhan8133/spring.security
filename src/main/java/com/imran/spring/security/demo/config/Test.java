package com.imran.spring.security.demo.config;

import org.springframework.stereotype.Component;

@Component
public class Test {
    private String roleUser;
    private String roleAdmin;

    public String getRoleUser() {
        return roleUser;
    }

    public String setRoleUser(String roleUser) {
        this.roleUser = roleUser;
        return this.roleUser;
    }

    public String getRoleAdmin() {
        return roleAdmin;
    }

    public String setRoleAdmin(String roleAdmin) {
        this.roleAdmin = roleAdmin;
        return this.roleAdmin;
    }
}
