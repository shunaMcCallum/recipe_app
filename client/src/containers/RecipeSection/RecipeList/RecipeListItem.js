import React from 'react';
import { Link } from 'react-router-dom';
import './RecipeList.scss';

const RecipeListItem = ({ recipe }) => {

    const url = "/recipes/" + recipe.id;
    
    return (
        <div className="recipe-list-item">
            <Link to={url}>{recipe.name}</Link>
        </div>
    )
    
}

export default RecipeListItem;