package com.imran.spring.security.demo.Security;


import com.google.common.collect.Sets;

import java.util.Set;


public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet());
   private final Set<ApplicationUserPermission> applicationUserPermissions;

    ApplicationUserRole(Set<ApplicationUserPermission> applicationUserPermissions) {
        this.applicationUserPermissions = applicationUserPermissions;
    }
}
