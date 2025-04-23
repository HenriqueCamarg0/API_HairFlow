package com.HenriqueCamarg0.API_HairFlow.Entity;

public enum UserRole {
    ADMIN,
    CUSTOMER;
    
    public boolean isAdmin() {
        return this == ADMIN;
    }

}
