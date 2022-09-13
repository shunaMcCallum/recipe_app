import './App.css';
import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Routes, Route, useParams } from "react-router-dom";
import Request from './helpers/request';
import HomePage from './containers/HomePage/HomePage';
import NavBar from './components/NavBar/NavBar';
import RecipeContainer from './containers/RecipeSection/RecipeContainer';
import IngredientContainer from './containers/IngredientSection/IngredientContainer';
import SelectedRecipe from './containers/RecipeSection/SelectedRecipe/SelectedRecipe';
import SelectedIngredient from './containers/IngredientSection/SelectedIngredient/SelectedIngredient';

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

  // Import ingredient data
  useEffect(() => {
    getIngredients();
  }, [])

  // Handle ingredient navigation
  const findIngredientById = (id) => {
    return ingredients.find((ingredient) => {
      return ingredient.id === parseInt(id);
    })
  }

  const IngredientWrapper = () => {
    const { id } = useParams();
    let foundIngredient = findIngredientById(id);
    console.log(foundIngredient);
    return <SelectedIngredient ingredient={foundIngredient} />;
  }

  const getIngredients = () => {
    Request.get('http://localhost:8080/ingredients/')
    .then(ingredientsData => setIngredients(ingredientsData))
  }

  return (
    <div className="app-container">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path="/" element={<HomePage />} />
          <Route exact path="/recipes" element={<RecipeContainer recipes={recipes} />} />
          <Route path="/recipes/:id" element={<RecipeWrapper />} />
          <Route exact path="/ingredients" element={<IngredientContainer ingredients={ingredients} />} />
          <Route path="/ingredients/:id" element={<IngredientWrapper />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
