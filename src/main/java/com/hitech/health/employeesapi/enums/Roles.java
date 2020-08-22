package com.hitech.health.employeesapi.enums;

public enum  Roles {
    USER(0),
    ADMIN(1);

    private int role;

    Roles(int role) {
        this.role = role;
    }
}
