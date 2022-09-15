package com.example.server.models.Enums;

public enum Tags {
    Healthy("Healthy"),
    Treat("Treat"),
    Quick("Quick"),
    Cheap("Cheap"),
    Curry("Curry"),
    Pasta("Pasta");

    private final String name;

    private Tags(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
