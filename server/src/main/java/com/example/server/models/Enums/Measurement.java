package com.example.server.models.Enums;

public enum Measurement {
    grams("grams"),
    millilitres("millilitres"),
    tablespoon("tablespoon"),
    teaspoon("teaspoon"),
    pack("pack"),
    large("large"),
    small("small"),
    item("item");

    private final String name;

    private Measurement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
