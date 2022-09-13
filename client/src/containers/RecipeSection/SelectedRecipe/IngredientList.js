import React from 'react';
import IngredientListItem from './IngredientListItem';

const IngredientList = ({ingredientList}) => {
    
    const ingredientItems = ingredientList.map((ingredient, index) => {
        return <IngredientListItem ingredient={ingredient} key={index} />
    })

    return (
        <div>
            {ingredientItems}
        </div>
    )
}

export default IngredientList;