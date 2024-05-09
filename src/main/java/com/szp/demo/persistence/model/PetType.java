package com.szp.demo.persistence.model;

public enum PetType {
    CAT, DOG;
    static PetType of(String name) {
        return PetType.valueOf(name.toUpperCase());
    }
}
