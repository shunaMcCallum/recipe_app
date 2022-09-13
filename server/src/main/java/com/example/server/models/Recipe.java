package com.example.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.server.models.Enums.Meal;
import com.example.server.models.Enums.Tags;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="meal")
    private Meal meal;
    @Column(name="calories")
    private Double calories;
    @Column(name="portions")
    private int portions;

    @JsonIgnoreProperties({"recipes"})
    @OneToMany(mappedBy="recipe", fetch = FetchType.LAZY)
    private List<PreparedIngredient> prepared_ingredients;
    @Column(name="cooking_time")
    private int cooking_time;
    @Column(name="instructions")
    private ArrayList<String> instructions;
    @Column(name="tags")
    private ArrayList<Tags> tags;

    public Recipe (String name, Meal meal, int cooking_time) {
        this.name = name;
        this.meal = meal;
        this.calories = 0.0;
        this.portions = 1;
        this.prepared_ingredients = new ArrayList<>();
        this.cooking_time = cooking_time;
        this.instructions = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public Recipe() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }

    public void addInstruction(String instruction) {
        this.instructions.add(instruction);
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public void addTag(Tags tag) {
        this.tags.add(tag);
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PreparedIngredient> getPreparedIngredients() {
        return prepared_ingredients;
    }

    public void setPreparedIngredients(List<PreparedIngredient> preparedIngredients) {
        this.prepared_ingredients = preparedIngredients;
    }

//    public ArrayList<Ingredient> getIngredientList() {
//        ArrayList<Ingredient> result = new ArrayList<>();
//
//        for (int i = 0; i < this.prepared_ingredients.size(); i++) {
//            result.add(this.prepared_ingredients.get(i).getIngredient());
//        }
//
//        return result;
//    }

    public void addPreparedIngredient(PreparedIngredient prepared_ingredient) {
        this.prepared_ingredients.add(prepared_ingredient);
    }

    public Double calculateTotalCalories() {
        Double total = 0.00;

        for (int i = 0; i < this.prepared_ingredients.size(); i++) {
            total += this.prepared_ingredients.get(i).getCaloriesPerPreparedIngredient() * this.portions;
        }
        return total;
    }

    public Double calculatePreparedIngredientMeasurementForVaryingPortions(PreparedIngredient preparedIngredient) {
        return preparedIngredient.getMeasurement() * this.portions;
    }
}


