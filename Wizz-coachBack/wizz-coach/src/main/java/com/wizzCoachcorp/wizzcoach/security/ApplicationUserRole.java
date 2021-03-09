package com.wizzCoachcorp.wizzcoach.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.wizzCoachcorp.wizzcoach.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    ELEVE(Sets.newHashSet()),
    COACH(Sets.newHashSet(COURSE_READ , COURSE_WRITE , ELEVE_READ , ELEVE_WRITE)),
    COACHSTAGIAIRE(Sets.newHashSet(COURSE_READ  , ELEVE_READ ));


    private final Set<ApplicationUserPermission> permissions;


    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
