package com.szp.demo.model;

public enum PetType {
    CAT, DOG;
    static PetType of(String name) {
        return PetType.valueOf(name.toUpperCase());
    }
}
