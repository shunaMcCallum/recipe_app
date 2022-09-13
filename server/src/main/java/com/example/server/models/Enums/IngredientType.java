package com.example.server.models.Enums;

import java.util.List;

public enum IngredientType {
    Vegetable("Vegetable"),
    Carb("Carb"),
    Dairy("Dairy"),
    Herb("Herb"),
    Spice("Spice"),
    Seasoning("Seasoning"),
    Meat("Meat"),
    Fruit("Fruit"),
    Bean ("Bean"),
    Tinned("Tinned"),
    Oil("Oil"),
    Milk("Milk");

    private final String name;

    private IngredientType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
