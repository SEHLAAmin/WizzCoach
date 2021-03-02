package com.wizzCoachcorp.wizzcoach.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.wizzCoachcorp.wizzcoach.security.ApplicationUserPermission.*;

public enum ApplictaionUserRole {
    ELEVE(Sets.newHashSet()),
    COACH(Sets.newHashSet(COURSE_READ , COURSE_WRITE , ELEVES_READ , ELEVES_WRITE));

    private final Set<ApplicationUserPermission> permissions;


    ApplictaionUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
