import React from 'react';
import './RecipeList.scss';
import RecipeListItem from './RecipeListItem';

const RecipeListContainer = ({recipes}) => {

    const recipeListItems = recipes.map((recipe, index) => {
        return <RecipeListItem recipe={recipe} key={index} />
    })

    return (
        <>
            <div>
                <h2>Recipe List</h2>
                {recipeListItems}
            </div>
        </>
        
    )
}

export default RecipeListContainer;