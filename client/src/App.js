import './App.css';
import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Routes, Route, useParams } from "react-router-dom";
import Request from './helpers/request';
import HomePage from './containers/HomePage/HomePage';
import NavBar from './components/NavBar/NavBar';
import RecipeContainer from './containers/RecipeSection/RecipeContainer';
import SelectedRecipe from './containers/RecipeSection/SelectedRecipe/SelectedRecipe';
import RecipeForm from './containers/RecipeSection/CreateRecipe/RecipeForm';
import IngredientContainer from './containers/IngredientSection/IngredientContainer';
import SelectedIngredient from './containers/IngredientSection/SelectedIngredient/SelectedIngredient';
import IngredientForm from './containers/IngredientSection/CreateIngredient/IngredientForm';

function App() {

  const [recipes, setRecipes] = useState([]);
  const [ingredients, setIngredients] = useState([]);

  // Import recipe data
  useEffect(() => {
    getRecipes();
  }, [])

  const getRecipes = () => {
    Request.get('http://localhost:8080/recipes/')
      .then(recipeData => setRecipes(recipeData))      
    // .then(recipeData => console.log(recipeData[0].preparedIngredients))
  }

  // Handle recipe navigation
  const findRecipeById = (id) => {
    return recipes.find((recipe) => {
      return recipe.id === parseInt(id);
    })
  }

  const RecipeWrapper = () => {
    const { id } = useParams();
    let foundRecipe = findRecipeById(id);
    return <SelectedRecipe recipe={foundRecipe} />;
  }

  const createRecipe = (recipe) => {
    // console.log(recipe);
    Request.post('http://localhost:8080/recipes/', recipe)
      // .then(() => window.location = '/recipes/');
  }

  const updateRecipe = (recipe, id) => {
    const url = 'http://localhost:8080/recipes/' + id;
    // console.log(recipe);
    Request.put(url, recipe)
    // .then(() => window.location = '/recipes/');
  }

  // const createPreparedIngredient = (preparedIngredient) => {
  //   // console.log(preparedIngredient);
  //   Request.post('http://localhost:8080/prepared_ingredients/', preparedIngredient)
  // }

  // Import ingredient data
  useEffect(() => {
    getIngredients();
  }, [])

  const getIngredients = () => {
    Request.get('http://localhost:8080/ingredients/')
      .then(ingredientsData => setIngredients(ingredientsData))
  }

  // Handle ingredient navigation
  const findIngredientById = (id) => {
    return ingredients.find((ingredient) => {
      return ingredient.id === parseInt(id);
    })
  }

  const IngredientWrapper = () => {
    const { id } = useParams();
    let foundIngredient = findIngredientById(id);
    return <SelectedIngredient ingredient={foundIngredient} />;
  }

  const createIngredient = (ingredient) => {
    // console.log("create ingredient called", ingredient);
    Request.post('http://localhost:8080/ingredients/', ingredient)
    .then(() => window.location = '/ingredients/');
  }

  return (
    <div className="app-container">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path="/" element={<HomePage />} />
          <Route exact path="/recipes" element={<RecipeContainer recipes={recipes} />} />
          <Route path="/recipes/:id" element={<RecipeWrapper />} />
          <Route exact path="/recipes/new" element={<RecipeForm onCreate={createRecipe} onUpdate={updateRecipe} ingredients={ingredients} />} />
          <Route exact path="/ingredients" element={<IngredientContainer ingredients={ingredients} />} />
          <Route path="/ingredients/:id" element={<IngredientWrapper />} />
          <Route exact path="/ingredients/new" element={<IngredientForm onCreate={createIngredient} />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
