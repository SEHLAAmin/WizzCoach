package com.wizzCoachcorp.wizzcoach.security;

public enum ApplicationUserPermission {
    ELEVE_READ("eleve:read"),
    ELEVE_WRITE("eleve:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:whrite");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
