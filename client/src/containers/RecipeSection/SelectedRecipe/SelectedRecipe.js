import React from 'react';
import IngredientList from './IngredientList';
import InstructionList from './InstructionList';

const SelectedRecipe = ({recipe}) => {
    
    const calories = Math.round(recipe.calories);

    return (
        <div>
            <h1>{recipe.name}</h1>
            <p>Calories: {calories} kcal</p>
            <p>Cooking Time: {recipe.cooking_time} mins</p>
            <div>
                <IngredientList ingredientList={recipe.preparedIngredients} />
                <InstructionList instructionList={recipe.instructions} />
            </div>
        </div>
    )
}

export default SelectedRecipe;