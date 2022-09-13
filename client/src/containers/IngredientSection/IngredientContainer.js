import React from 'react';
import './IngredientContainer.scss';
import IngredientListContainer from './IngredientList/IngredientListContainer';

const IngredientContainer = ({ ingredients }) => {


    return (
        <div className="ingredient-container">
            <h1>Ingredients Section</h1>
            <IngredientListContainer ingredients={ingredients} />
        </div>
    )
}

export default IngredientContainer;