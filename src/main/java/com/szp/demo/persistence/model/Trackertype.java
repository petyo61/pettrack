package com.szp.demo.persistence.model;

public enum Trackertype {
    SMALL, MEDIUM, BIG;
    static Trackertype of(String name) {
        return Trackertype.valueOf(name.toUpperCase());
    }
}
