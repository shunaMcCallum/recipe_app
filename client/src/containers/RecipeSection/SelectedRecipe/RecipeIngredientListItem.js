import React from 'react';

const RecipeIngredientListItem = ({ingredient}) => {
  

    return (
        <div className="recipe-ingredient-list-item">
            <p>{ingredient.name}</p>
        </div>
    )
}

export default RecipeIngredientListItem;