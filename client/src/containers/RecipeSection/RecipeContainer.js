import React from 'react';
import { useNavigate } from 'react-router-dom';
import './RecipeContainer.scss';
import RecipeListContainer from './RecipeList/RecipeListContainer';

const RecipeContainer = ({ recipes }) => {
    const navigate = useNavigate();
    
    const handleCreateButtonClick = () => {
        navigate('/recipes/new')
    }

    return (
        <div className="recipe-container">
            <h1>Recipes Section</h1>
            <p>Create New Recipe:</p>
            <button onClick={handleCreateButtonClick}>Create</button>
            <RecipeListContainer recipes={recipes} />
        </div>
    )
}

export default RecipeContainer;