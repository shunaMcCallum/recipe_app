import './App.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from './containers/HomePage/HomePage';
import NavBar from './components/NavBar/NavBar';
import RecipeContainer from './containers/RecipeSection/RecipeContainer';
import IngredientContainer from './containers/IngredientSection/IngredientContainer';

function App() {
  return (
    <div className="app-container">
      <Router>
        <NavBar />
        <Routes>
          <Route exact path="/" element={<HomePage />} />
          <Route exact path="/recipes" element={<RecipeContainer />} />
          <Route exact path="/ingredients" element={<IngredientContainer />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
