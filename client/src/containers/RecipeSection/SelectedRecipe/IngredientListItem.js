import React from 'react';

const IngredientListItem = ({ingredient}) => {
  

    return (
        <div>
            <p>{ingredient.ingredient.name} - {ingredient.measurement} {ingredient.measurementType}, {ingredient.preparation}</p>
        </div>
    )
}

export default IngredientListItem;