package com.szp.demo.model;

public enum TrackerType {
    SMALL, MEDIUM, BIG;
    public static TrackerType of(String name) {
        return name == null ? null : TrackerType.valueOf(name.toUpperCase());
    }
}
