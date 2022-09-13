package com.example.server;

import com.example.server.models.Enums.Meal;
import com.example.server.models.PreparedIngredient;
import com.example.server.models.Recipe;
import com.example.server.repositories.IngredientRepository;
import com.example.server.repositories.PreparedIngredientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.server.models.Enums.IngredientType;
import com.example.server.models.Enums.Measurement;
import com.example.server.models.Ingredient;
import com.example.server.repositories.RecipeRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@RunWith(SpringRunner.class)
//@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
class ServerApplicationTests {

	@Autowired
    IngredientRepository ingredientRepository;

	@Autowired
    PreparedIngredientRepository preparedIngredientRepository;

	@Autowired
	RecipeRepository recipeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindRecipes() {
		List<Recipe> found = recipeRepository.findAll();
		assertEquals(found.size(), 1);
	}

	@Test
	public void canFindIngredients() {
		List<Ingredient> found = ingredientRepository.findAll();
		assertEquals(found.size(), 3);
	}

	@Test
	public void canFindPreparedIngredients() {
		List<PreparedIngredient> found = preparedIngredientRepository.findAll();
		assertEquals(found.size(), 3);
	}

	@Test
	public void canAddPreparedIngredientToRecipe() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Ingredient lettuce = new Ingredient("lettuce", IngredientType.Vegetable, 10.0, 1, Measurement.item);
		ingredientRepository.save(lettuce);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);
		PreparedIngredient ingredient3 = new PreparedIngredient(lettuce, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient3);

		recipe2.addPreparedIngredient(ingredient2);
		recipeRepository.save(recipe2);
		recipe2.addPreparedIngredient(ingredient3);
		recipeRepository.save(recipe2);

		assertEquals(recipe2.getPreparedIngredients().size(), 2);
	}

	@Test
	public void canGetIngredientsFromRecipe() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Ingredient lettuce = new Ingredient("lettuce", IngredientType.Vegetable, 10.0, 1, Measurement.item);
		ingredientRepository.save(lettuce);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);
		PreparedIngredient ingredient3 = new PreparedIngredient(lettuce, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient3);

		recipe2.addPreparedIngredient(ingredient2);
		recipeRepository.save(recipe2);
		recipe2.addPreparedIngredient(ingredient3);
		recipeRepository.save(recipe2);

		assertEquals(recipe2.getIngredientList().size(), 2);
	}

	@Test
	public void canGetIngredientNameFromRecipe() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);

		recipe2.addPreparedIngredient(ingredient2);
		recipeRepository.save(recipe2);

		assertEquals(recipe2.getIngredientList().get(0).getName(), "broccoli");
	}

	@Test
	public void canGetIngredientCalories() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);

		assertEquals(30.0, broccoli.getCalories());
	}

	@Test
	public void canGetPreparedIngredientCalories() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);

		assertEquals(60.0, ingredient2.getCaloriesPerPreparedIngredient());
	}

	@Test
	public void canCalculateRecipeCaloriesOnePortion() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Ingredient lettuce = new Ingredient("lettuce", IngredientType.Vegetable, 10.0, 1, Measurement.item);
		ingredientRepository.save(lettuce);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);
		PreparedIngredient ingredient3 = new PreparedIngredient(lettuce, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient3);

		recipe2.addPreparedIngredient(ingredient2);
		recipeRepository.save(recipe2);
		recipe2.addPreparedIngredient(ingredient3);
		recipeRepository.save(recipe2);

		assertEquals(80.0,recipe2.calculateTotalCalories());
	}

	@Test
	public void canCalculateRecipeCaloriesVaryingPortions() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Ingredient lettuce = new Ingredient("lettuce", IngredientType.Vegetable, 10.0, 1, Measurement.item);
		ingredientRepository.save(lettuce);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);
		PreparedIngredient ingredient3 = new PreparedIngredient(lettuce, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient3);

		recipe2.addPreparedIngredient(ingredient2);
		recipeRepository.save(recipe2);
		recipe2.addPreparedIngredient(ingredient3);
		recipeRepository.save(recipe2);

		recipe2.setPortions(2);
		recipeRepository.save(recipe2);

		assertEquals(160.0, recipe2.calculateTotalCalories());
	}

	@Test
	public void canUpdatePreparedIngredientMeasurementsWithVaryingPortions() {
		Ingredient broccoli = new Ingredient("broccoli", IngredientType.Vegetable, 30.0, 1, Measurement.item);
		ingredientRepository.save(broccoli);
		Ingredient lettuce = new Ingredient("lettuce", IngredientType.Vegetable, 10.0, 1, Measurement.item);
		ingredientRepository.save(lettuce);
		Recipe recipe2 = new Recipe("Bean Curry", Meal.Dinner, 60);
		recipeRepository.save(recipe2);
		PreparedIngredient ingredient2 = new PreparedIngredient(broccoli, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient2);
		PreparedIngredient ingredient3 = new PreparedIngredient(lettuce, 2.0, Measurement.item, "chopped", recipe2);
		preparedIngredientRepository.save(ingredient3);

		recipe2.addPreparedIngredient(ingredient2);
		recipeRepository.save(recipe2);
		recipe2.addPreparedIngredient(ingredient3);
		recipeRepository.save(recipe2);

		recipe2.setPortions(2);
		recipeRepository.save(recipe2);

		assertEquals(4.0, recipe2.calculatePreparedIngredientMeasurementForVaryingPortions(recipe2.getPreparedIngredients().get(0)));

	}


}
