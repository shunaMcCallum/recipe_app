import './App.css';
import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Routes, Route, useParams } from "react-router-dom";
import Request from './helpers/request';
import HomePage from './containers/HomePage/HomePage';
import NavBar from './components/NavBar/NavBar';
import RecipeContainer from './containers/RecipeSection/RecipeContainer';
import SelectedRecipe from './containers/RecipeSection/SelectedRecipe/SelectedRecipe';
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
    return <SelectedIngredient ingredient={foundIngredient} />;
  }

  const getIngredients = () => {
    Request.get('http://localhost:8080/ingredients/')
    .then(ingredientsData => setIngredients(ingredientsData))
  }

  const createIngredient = (ingredient) => {
    console.log("create ingredient called", ingredient);
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
          <Route exact path="/ingredients" element={<IngredientContainer ingredients={ingredients} />} />
          <Route path="/ingredients/:id" element={<IngredientWrapper />} />
          <Route exact path="/ingredients/new" element={<IngredientForm onCreate={createIngredient} />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
