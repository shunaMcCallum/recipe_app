import React from 'react';
import './IngredientList.scss';
import IngredientListItem from './IngredientListItem';

const IngredientListContainer = ({ ingredients }) => {

    const IngredientListItems = ingredients.map((ingredient, index) => {
        return <IngredientListItem ingredient={ingredient} key={index} />
    })

    return (
        <div className="ingredient-list">
            <h2>Ingredient List</h2>
            {IngredientListItems}
        </div>

    )
}

export default IngredientListContainer;