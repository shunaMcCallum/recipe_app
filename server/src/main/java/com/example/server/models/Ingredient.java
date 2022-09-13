package com.example.server.models;

import com.example.server.models.Enums.IngredientType;
import com.example.server.models.Enums.Measurement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private IngredientType type;

    @Column(name="calories")
    private Double calories;

    @Column(name="measurement")
    private int measurement;

    @Column(name="measurement_type")
    private Measurement measurement_type;

//    @JsonIgnoreProperties({"ingredients"})
    @JsonBackReference
    @OneToMany(mappedBy="ingredient", fetch = FetchType.LAZY)
    private List<PreparedIngredient> preparedIngredients;

    public Ingredient (String name, IngredientType type, Double calories, Measurement measurement_type) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.measurement = 1;
        this.measurement_type = measurement_type;
        this.preparedIngredients = new ArrayList<>();
    }

    public Ingredient () {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public int getMeasurement() {
        return measurement;
    }

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }

    public Measurement getMeasurement_type() {
        return measurement_type;
    }

    public void setMeasurement_type(Measurement measurement_type) {
        this.measurement_type = measurement_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PreparedIngredient> getPreparedIngredients() {
        return preparedIngredients;
    }

    public void setPreparedIngredients(List<PreparedIngredient> preparedIngredients) {
        this.preparedIngredients = preparedIngredients;
    }
}
