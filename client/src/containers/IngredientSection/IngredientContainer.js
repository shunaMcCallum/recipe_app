import React from 'react';
import {useNavigate } from 'react-router-dom';
import './IngredientContainer.scss';
import IngredientListContainer from './IngredientList/IngredientListContainer';

const IngredientContainer = ({ ingredients }) => {
    const navigate = useNavigate();

    const handleCreateButtonClick = () => {
        navigate('/ingredients/new')
    }

    return (
        <div className="ingredient-container">
            <h1>Ingredients Section</h1>
            <p>Create New Ingredient:</p>
            <button onClick={handleCreateButtonClick}>Create</button>
            <IngredientListContainer ingredients={ingredients} />
        </div>
    )
}

export default IngredientContainer;