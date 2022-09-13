import React from 'react';
import './NavBar.scss';
import { useNavigate } from "react-router-dom";

const NavBar = () => {
    const navigate = useNavigate();

    const handleHomeButtonClick = () => {
        navigate("/");
    }

    const handleRecipeButtonClick = () => {
        navigate("/recipes");
    }

    const handleIngredientButtonClick = () => {
        navigate("/ingredients");
    }

    return (
        <div className="nav-bar-container">
            <div className="nav-bar-buttons-container">
                <button className="nav-bar-button" onClick={handleHomeButtonClick}>Home</button>
                <button className="nav-bar-button" onClick={handleRecipeButtonClick}>Recipes</button>
                <button className="nav-bar-button" onClick={handleIngredientButtonClick}>Ingredients</button>
            </div>
        </div>
    )
}

export default NavBar;