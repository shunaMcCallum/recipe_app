package com.example.server.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.server.models.Enums.Meal;
import com.example.server.models.Enums.Tags;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

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

//    @JsonIgnoreProperties({"recipes"})
////    @JsonBackReference
//    @OneToMany(mappedBy="recipe", fetch = FetchType.LAZY)
//    private ArrayList<PreparedIngredient> prepared_ingredients;

    @JsonIgnoreProperties({"recipes"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "recipes_ingredients",
            joinColumns = {@JoinColumn(name = "recipe_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id", nullable = false, updatable = false)}
    )
    private List<Ingredient> ingredients;

    @Column(name="cooking_time")
    private int cooking_time;
    @Column(name="instructions")
    private ArrayList<String> instructions;
    @Column(name="tags")
    private ArrayList<Tags> tags;

//    public Recipe (String name, Meal meal, int cooking_time, int portions, Double calories, ArrayArrayList<PreparedIngredient> prepared_ingredients, ArrayArrayList<String> instructions, ArrayArrayList<Tags> tags) {
//        this.name = name;
//        this.meal = meal;
//        this.cooking_time = cooking_time;
//        this.portions = portions;
//        this.calories = calories;
//        this.prepared_ingredients = prepared_ingredients;
//        this.instructions = instructions;
//        this.tags = tags;
//    }

    public Recipe (String name, Meal meal, int cooking_time, int portions, Double calories, List<Ingredient> ingredients, ArrayList<String> instructions, ArrayList<Tags> tags) {
        this.name = name;
        this.meal = meal;
        this.cooking_time = cooking_time;
        this.portions = portions;
        this.calories = calories;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.tags = tags;
    }

    public Recipe (String name, Meal meal, int cooking_time, int portions, Double calories, List<Ingredient> ingredients, ArrayList<String> instructions) {
        this(name, meal, cooking_time, portions, calories, ingredients, instructions, new ArrayList<Tags>());
    }

    public Recipe (String name, Meal meal, int cooking_time, int portions, Double calories, List<Ingredient> ingredients) {
        this(name, meal, cooking_time, portions, calories, ingredients, new ArrayList<String>());
    }

    public Recipe (String name, Meal meal, int cooking_time, int portions, Double calories) {
        this(name, meal, cooking_time, portions, calories, new ArrayList<>());
    }

    public Recipe (String name, Meal meal, int cooking_time, int portions) {
        this(name, meal, cooking_time, portions, 0.0);
//        this.calculateTotalCalories();
    }

    public Recipe (String name, Meal meal, int cooking_time) {
        this(name, meal, cooking_time, 1);
    }

    public Recipe (String name, Meal meal) {
        this(name, meal, 0);
    }

    public Recipe (String name) {
        this(name, null);
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


//    public ArrayList<PreparedIngredient> getPrepared_ingredients() {
//        return prepared_ingredients;
//    }
//
//    public void setPrepared_ingredients(ArrayList<PreparedIngredient> prepared_ingredients) {
//        this.prepared_ingredients = prepared_ingredients;
//    }
//
//    public void addPreparedIngredient(PreparedIngredient preparedIngredient) {
//        this.prepared_ingredients.add(preparedIngredient);
//    }
//
//    public Double calculateTotalCalories() {
//        Double total = 0.00;
//
//        for (int i = 0; i < this.prepared_ingredients.size(); i++) {
//            total += this.prepared_ingredients.get(i).getCaloriesPerPreparedIngredient() * this.portions;
//        }
//        return total;
//    }
//
//    public Double calculatePreparedIngredientMeasurementForVaryingPortions(PreparedIngredient preparedIngredient) {
//        return preparedIngredient.getMeasurement() * this.portions;
//    }
}


