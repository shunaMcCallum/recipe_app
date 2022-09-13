package com.example.server.components;

import com.example.server.models.Enums.Meal;
import com.example.server.models.Enums.Measurement;
import com.example.server.models.PreparedIngredient;
import com.example.server.models.Recipe;
import com.example.server.repositories.IngredientRepository;
import com.example.server.repositories.PreparedIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.example.server.models.Enums.IngredientType;
import com.example.server.models.Enums.Tags;
import com.example.server.models.Ingredient;
import com.example.server.repositories.RecipeRepository;

@Profile("!test") //Run every time EXCEPT Tests
@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    PreparedIngredientRepository preparedIngredientRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Ingredient aubergine = new Ingredient("aubergine", IngredientType.Vegetable, 0.25, Measurement.grams);
        ingredientRepository.save(aubergine);

        Ingredient coconutOil = new Ingredient("coconut oil", IngredientType.Oil, 8.62, Measurement.grams);
        ingredientRepository.save(coconutOil);

        Ingredient onion = new Ingredient("onion", IngredientType.Vegetable, 0.40, Measurement.grams);
        ingredientRepository.save(onion);

        Ingredient ginger = new Ingredient("ginger", IngredientType.Spice, 0.80, Measurement.grams);
        ingredientRepository.save(ginger);

        Ingredient garlic = new Ingredient("garlic clove", IngredientType.Herb, 1.49, Measurement.grams);
        ingredientRepository.save(garlic);

        Ingredient redChilli = new Ingredient("red chilli", IngredientType.Spice, 0.40, Measurement.grams);
        ingredientRepository.save(redChilli);

        Ingredient turmeric = new Ingredient("turmeric powder", IngredientType.Spice, 3.54, Measurement.grams);
        ingredientRepository.save(turmeric);

        Ingredient groundCoriander = new Ingredient("ground coriander", IngredientType.Herb, 4.46, Measurement.grams);
        ingredientRepository.save(groundCoriander);

        Ingredient cardamom = new Ingredient("cardamom pod", IngredientType.Spice, 3.11, Measurement.grams);
        ingredientRepository.save(cardamom);

        Ingredient tomato = new Ingredient("tomato", IngredientType.Fruit, 0.18, Measurement.grams);
        ingredientRepository.save(tomato);

        Ingredient coconutMilk = new Ingredient("coconut milk", IngredientType.Milk, 1.42, Measurement.millilitres);
        ingredientRepository.save(coconutMilk);

        Ingredient coriander = new Ingredient("coriander", IngredientType.Herb, 0.31, Measurement.grams);
        ingredientRepository.save(coriander);

        Ingredient whiteRice = new Ingredient("white rice", IngredientType.Carb, 1.29, Measurement.grams);
        ingredientRepository.save(whiteRice);

        Recipe recipe = new Recipe("Roast Aubergine & Coconut Curry", Meal.Dinner, 65);
        recipeRepository.save(recipe);

        PreparedIngredient ingredient1 = new PreparedIngredient(aubergine, 200.0, Measurement.grams, "chopped into quarters", recipe);
        preparedIngredientRepository.save(ingredient1);

        PreparedIngredient ingredient2 = new PreparedIngredient(coconutOil, 7.5, Measurement.grams, " ", recipe);
        preparedIngredientRepository.save(ingredient2);

        PreparedIngredient ingredient3 = new PreparedIngredient(ginger, 1.25, Measurement.grams, "thumb piece grated", recipe);
        preparedIngredientRepository.save(ingredient3);

        PreparedIngredient ingredient4 = new PreparedIngredient(garlic, 0.9, Measurement.grams, "crushed", recipe);
        preparedIngredientRepository.save(ingredient4);

        PreparedIngredient ingredient5 = new PreparedIngredient(redChilli, 4.0, Measurement.grams, "deseeded and chopped", recipe);
        preparedIngredientRepository.save(ingredient5);

        PreparedIngredient ingredient6 = new PreparedIngredient(turmeric, 1.25, Measurement.grams, " ", recipe);
        preparedIngredientRepository.save(ingredient6);

        PreparedIngredient ingredient7 = new PreparedIngredient(groundCoriander, 2.5, Measurement.grams, "2 tsp", recipe);
        preparedIngredientRepository.save(ingredient7);

        PreparedIngredient ingredient8 = new PreparedIngredient(cardamom, 1.0, Measurement.grams, "crushed", recipe);
        preparedIngredientRepository.save(ingredient8);

        PreparedIngredient ingredient9 = new PreparedIngredient(tomato, 250.0, Measurement.grams, "roughly chopped", recipe);
        preparedIngredientRepository.save(ingredient9);

        PreparedIngredient ingredient10 = new PreparedIngredient(coconutMilk, 100.0, Measurement.millilitres, " ", recipe);
        preparedIngredientRepository.save(ingredient10);

        PreparedIngredient ingredient11 = new PreparedIngredient(coriander, 5.0, Measurement.grams, "chopped", recipe);
        preparedIngredientRepository.save(ingredient11);

        PreparedIngredient ingredient12 = new PreparedIngredient(whiteRice, 50.0, Measurement.grams, " ", recipe);
        preparedIngredientRepository.save(ingredient12);

        PreparedIngredient ingredient13 = new PreparedIngredient(onion, 80.0, Measurement.grams, "chopped", recipe);
        preparedIngredientRepository.save(ingredient13);

        recipe.addPreparedIngredient(ingredient1);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient2);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient3);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient4);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient5);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient6);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient7);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient8);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient9);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient10);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient11);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient12);
        recipeRepository.save(recipe);
        recipe.addPreparedIngredient(ingredient13);
        recipeRepository.save(recipe);

        recipe.addInstruction("1. Heat the oven. Spread out the aubergine on a roasting tin and drizzle with the oil and some seasoning. Roast for 15-20 mins.");
        recipeRepository.save(recipe);

        recipe.addInstruction("2. Heat some oil in a flameproof dish and cook the onions over a medium heat. Add the ginger, garlic and chilli and cook for another 3 mins, then add the turmeric, coriander and cardamom pods. Stir for 1 min, then add the tomatoes and some seasoning. Cook until the tomatoes begin to soften, stirring, then add the coconut milk, 75ml water and the aubergine.");
        recipeRepository.save(recipe);

        recipe.addInstruction("3. Bring the pot to just under the boil, then turn down to a gentle simmer. Simmer for 30 mins, stirring every so often. Add a pinch of sugar if it needs it. Stir in the coriander and serve with rice or naan breads.");
        recipeRepository.save(recipe);

        recipe.addTag(Tags.Healthy);
        recipeRepository.save(recipe);

        recipe.addTag(Tags.Cheap);
        recipeRepository.save(recipe);

        recipe.addTag(Tags.Curry);
        recipeRepository.save(recipe);

        recipe.setCalories(recipe.calculateTotalCalories());
        recipeRepository.save(recipe);

    }

}
