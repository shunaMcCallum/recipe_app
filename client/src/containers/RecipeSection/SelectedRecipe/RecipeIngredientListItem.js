import React from 'react';

const RecipeIngredientListItem = ({ingredient}) => {
  

    return (
        <div className="recipe-ingredient-list-item">
            <p>{ingredient.ingredient.name} - {ingredient.measurement} {ingredient.measurementType}, {ingredient.preparation}</p>
        </div>
    )
}

export default RecipeIngredientListItem;