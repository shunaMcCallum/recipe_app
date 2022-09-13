import React from 'react';
import { Link } from 'react-router-dom';
import './IngredientList.scss';

const IngredientListItem = ({ ingredient }) => {

    const url = "/ingredients/" + ingredient.id;

    return (
        <div className="ingredient-list-item">
            <Link to={url}>{ingredient.name}</Link>
        </div>
    )

}

export default IngredientListItem;