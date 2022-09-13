import React from 'react';

const SelectedIngredient = ({ ingredient }) => {


    return (
        <div className="selected-ingredient">
            <h1>Name: {ingredient.name}</h1>
            <p>Type: {ingredient.type}</p>
            <p>Calories: {ingredient.calories}kcal per {ingredient.measurement} {ingredient.measurement_type}</p>
        </div>
    )
}

export default SelectedIngredient;