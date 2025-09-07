package com.devjefiro.marketing_place.domain.model;

public enum RoleEnum {

    ADMIN("admin"),
    COLABORADOR("colaborador");

    private final String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


