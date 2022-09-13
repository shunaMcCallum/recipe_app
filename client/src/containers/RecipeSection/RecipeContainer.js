import React from 'react';
import './RecipeContainer.scss';
import RecipeListContainer from './RecipeList/RecipeListContainer';

const RecipeContainer = ({recipes}) => {
  

    return (
        <div>
            <h1>Recipes Section</h1>
            <RecipeListContainer recipes={recipes} />
        </div>
    )
}

export default RecipeContainer;