package ru.vironit.app.entities;

public enum Role {
    ADMIN,
    CLIENT,
    INSURER;

    public String toString(Role role) {
        switch (role) {
            case ADMIN -> {
                return "ADMIN";
            }
            case CLIENT -> {
                return "CLIENT";
            }
            case INSURER -> {
                return "INSURER";
            }
        }
        return null;
    }

    public Role toRole(String string) {
        switch (string) {
            case "ADMIN": {
                return ADMIN;
            }
            case "CLIENT": {
                return CLIENT;
            }
            case "INSURER": {
                return INSURER;
            }
        }
        return null;
    }
}

