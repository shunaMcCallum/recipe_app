import React from 'react';
import RecipeIngredientListItem from './RecipeIngredientListItem';

const RecipeIngredientList = ({ingredientList}) => {
    
    const ingredientItems = ingredientList.map((ingredient, index) => {
        return <RecipeIngredientListItem ingredient={ingredient} key={index} />
    })

    return (
        <div className="recipe-ingredient-list">
            {ingredientItems}
        </div>
    )
}

export default RecipeIngredientList;