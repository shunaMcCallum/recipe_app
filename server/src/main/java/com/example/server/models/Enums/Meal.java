package com.example.server.models.Enums;

public enum Meal {
    Breakfast("Breakfast"),
    Lunch ("Lunch"),
    Dinner("Dinner"),
    Snack("Snack"),
    Dessert("Dessert");

    private final String name;

    private Meal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
