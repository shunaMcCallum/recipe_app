import React from 'react';
import RecipeIngredientList from './RecipeIngredientList';
import InstructionList from './InstructionList';

const SelectedRecipe = ({recipe}) => {
    
    const calories = Math.round(recipe.calories);

    return (
        <div className="selected-recipe">
            <h1>{recipe.name}</h1>
            <p>Calories: {calories} kcal</p>
            <p>Cooking Time: {recipe.cooking_time} mins</p>
            <div>
                <RecipeIngredientList ingredientList={recipe.preparedIngredients} />
                <InstructionList instructionList={recipe.instructions} />
            </div>
        </div>
    )
}

export default SelectedRecipe;