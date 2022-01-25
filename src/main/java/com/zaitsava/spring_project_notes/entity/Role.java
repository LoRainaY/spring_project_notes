package com.zaitsava.spring_project_notes.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
