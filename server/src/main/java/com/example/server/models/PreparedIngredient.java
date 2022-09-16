package com.example.server.models;

import com.example.server.models.Enums.Measurement;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="prepared_ingredients")
public class PreparedIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ingredient_id", nullable = false)
    @JsonIgnoreProperties({"prepared_ingredients"})
//    @JsonBackReference
    private Ingredient ingredient;

    @Column(name="measurement")
    private Double measurement;

    @Column(name="measurementType")
    private Measurement measurementType;

    @Column(name="preparation")
    private String preparation;

    @ManyToOne
    @JoinColumn(name="recipe_id", nullable = true)
    @JsonBackReference
//    @JsonIgnoreProperties({"prepared_ingredients"})
    private Recipe recipe;

    private Double caloriesPerPreparedIngredient;


    public PreparedIngredient(Ingredient ingredient, Double measurement, Measurement measurementType, String preparation, Recipe recipe, Double calories) {
        this.ingredient = ingredient;
        this.measurement = measurement;
        this.measurementType = measurementType;
        this.preparation = preparation;
        this.recipe = recipe;
        this.caloriesPerPreparedIngredient = calories;
    }

    public PreparedIngredient(Ingredient ingredient, Double measurement, Measurement measurementType, String preparation, Recipe recipe) {
        this(ingredient, measurement, measurementType, preparation, recipe, 0.0);
        this.setCaloriesPerPreparedIngredient();
    }

    public PreparedIngredient(Ingredient ingredient, Double measurement, Measurement measurementType, String preparation) {
        this(ingredient, measurement, measurementType, preparation, null);
        this.setCaloriesPerPreparedIngredient();
    }

    public PreparedIngredient(){

    }

    public Double getMeasurement() {
        return measurement;
    }

    public Measurement getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(Measurement measurementType) {
        this.measurementType = measurementType;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setCaloriesPerPreparedIngredient() {
        this.caloriesPerPreparedIngredient = Math.floor(this.getIngredient().getCalories() * this.measurement);
    }

    public Double getCaloriesPerPreparedIngredient() {
        return this.caloriesPerPreparedIngredient;
    }
}
