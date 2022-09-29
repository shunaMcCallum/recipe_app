import React, { useEffect, useState } from 'react';
import Request from '../../../helpers/request';

const RecipeForm = ({ onCreate, onUpdate, ingredients }) => {

    const [meals, setMeals] = useState([]);
    const [tags, setTags] = useState([]);
    const [measurementTypes, setMeasurementTypes] = useState([]);

    const [recipe, setRecipe] = useState({
        // name: "",
        // meal: "",
        // calories: 0,
        // portions: 0,
        // preparedIngredients: [],
        // cooking_time: 0,
        // instructions: [],
        // tags: []
    });
    const [ingredient, setIngredient] = useState({});
    const [ingredientList, setIngredientList] = useState([]);

    // const [preparedIngredient, setPreparedIngredient] = useState({
        // ingredient: {},
        // measurement: 0,
        // measurementType: "",
        // preparation: "",
        // caloriesPerPreparedIngredient: 0
    // });
    // const [preparedIngredientsList, setPreparedIngredientsList] = useState([]);
    const [ingredientFormValues, setIngredientFormValues] = useState([{}]);


    // fetch eNums from backend
    useEffect(() => {
        getMeals();
    }, [])

    useEffect(() => {
        getTags();
    }, [])

    useEffect(() => {
        getMeasurementTypes();
    }, [])

    const getMeals = () => {
        Request.get('http://localhost:8080/meal')
            .then(mealData => setMeals(mealData));
    }

    const getTags = () => {
        Request.get('http://localhost:8080/tags')
            .then(tagData => setTags(tagData));
    }

    const getMeasurementTypes = () => {
        Request.get('http://localhost:8080/measurements')
            .then(measurementData => setMeasurementTypes(measurementData));
    }


    // handle form events
    const handleChange = (event) => {
        let propertyName = event.target.name;
        let copiedRecipe = { ...recipe }
        copiedRecipe[propertyName] = event.target.value;
        setRecipe(copiedRecipe)
    }

    const handleMeal = function (event) {
        const index = parseInt(event.target.value)
        const selectedMeal = meals[index]
        let copiedRecipe = { ...recipe };
        copiedRecipe['meal'] = selectedMeal
        setRecipe(copiedRecipe)
    }

    const handleTags = function (event) {
        const index = parseInt(event.target.value)
        const selectedTag = tags[index]
        let copiedRecipe = { ...recipe };
        copiedRecipe['tags'] = [];
        copiedRecipe['tags'].push(selectedTag);
        setRecipe(copiedRecipe)
    }

    const handleInstructions = (event) => {
        let copiedRecipe = { ...recipe }
        copiedRecipe['instructions'] = [];
        copiedRecipe['instructions'].push(event.target.value);
        setRecipe(copiedRecipe)
    }

    // submitting prepared ingredients
    // const handlePreparedIngredientChange = (index, event) => {
    //     let data = [...ingredientFormValues];
    //     data[index][event.target.name] = event.target.value
    //     setPreparedIngredient(data);

    //     const copiedList = preparedIngredientsList;
    //     copiedList[index] = data;
    //     setPreparedIngredientsList(copiedList);
    // }

    // const handleIngredients = function (index, event) {
    //     const i = parseInt(event.target.value)
    //     const selectedIngredient = ingredients[i]

    //     let data = [...ingredientFormValues];
    //     data[index][event.target.name] = selectedIngredient
    //     setPreparedIngredient(data)

    //     const copiedList = preparedIngredientsList;
    //     copiedList[index] = data;
    //     setPreparedIngredientsList(copiedList);
    // }

    // const handleMeasurementType = function (index, event) {
    //     const i = parseInt(event.target.value)
    //     const selectedType = measurementTypes[i]

    //     let data = [...ingredientFormValues];
    //     data[index][event.target.name] = selectedType
    //     setPreparedIngredient(data)

    //     const copiedList = preparedIngredientsList;
    //     copiedList[index] = data;
    //     setPreparedIngredientsList(copiedList);
    // }

    // const handleAllPreparedIngredientsSubmit = function (event) {
    //     event.preventDefault();

    //     // let copiedRecipe = { ...recipe };
    //     // copiedRecipe['prepared_ingredients'] = [];
    //     ingredientFormValues.forEach((element) => {
    //         // copiedRecipe.prepared_ingredients.push(element);
    //         onPreparedIngredient(element);
    //     })

    //     // getPreparedIngredients();
    //     // copiedRecipe.prepared_ingredients = preparedIngredientsList;
    //     // setRecipe(copiedRecipe);
    // }

        const handleIngredientSelect = function (event) {
        const i = parseInt(event.target.value)
        const selectedIngredient = ingredients[i]

        const copiedList = ingredientList;
            copiedList.push(selectedIngredient);
        setIngredientList(copiedList);
    }

    const handleIngredientsSubmit = function (event) {
        event.preventDefault();

        let copiedRecipe = { ...recipe };
        copiedRecipe['ingredients'] = [];
        ingredientList.forEach((element) => {
            copiedRecipe.ingredients.push(element)
        })
        setRecipe(copiedRecipe);
    }

    // add more ingredients
    const addAnotherIngredient = function () {
        setIngredientFormValues([...ingredientFormValues, {}])
    }

    // create recipe
    const handleSubmit = function (event) {
        event.preventDefault();
        onCreate(recipe);
    }


    const mealOptions = meals.map((meal, index) => {
        return <option key={index} value={index}>{meal}</option>
    })

    const tagsOptions = tags.map((tag, index) => {
        return <option key={index} value={index}>{tag}</option>
    })

    const ingredientsOptions = ingredients.map((ingredient, index) => {
        return <option key={index} value={index}>{ingredient.name}</option>
    })

    const measurementTypeOptions = measurementTypes.map((measurement_type, index) => {
        return <option key={index} value={index}>{measurement_type}</option>
    })



    return (
        <div className="recipe-form">
                <input type="text" placeholder="Recipe name" name="name" onChange={handleChange} defaultValue={recipe.name} />
                <select name="type" onChange={handleMeal} defaultValue="select-meal">
                    <option disabled value="select-meal">Select a meal</option>
                    {mealOptions}
                </select>
                <input type="number" placeholder="Number of portions" name="portions" onChange={handleChange} defaultValue={recipe.portions} />
                <input type="number" step="0.01" placeholder="Cooking time" name="cooking_time" onChange={handleChange} defaultValue={recipe.cooking_time} />
                <br />
            <br />
            
                <p>Add ingredients:</p>
                <form onSubmit={handleIngredientsSubmit}>
                {ingredientFormValues.map((element, index) => {
                    return (
                        <div key={index}>
                            <select name="ingredient" onChange={event => handleIngredientSelect(index, event)} defaultValue={"select-ingredient"} >
                                <option disabled value="select-ingredient">Select an ingredient</option>
                                {ingredientsOptions}
                            </select>
                            {/* <input type="number" step="0.01" placeholder="Measurement" name="measurement" onChange={event => handlePreparedIngredientChange(index, event)} defaultValue={element.measurement} /> */}
                            {/* <select name="measurementType" onChange={event => handleMeasurementType(index, event)} defaultValue={"select-measurement-type"}> */}
                                {/* <option disabled value="select-measurement-type">Select a measurement type</option> */}
                                {/* {measurementTypeOptions} */}
                            {/* </select> */}
                            {/* <input type="text" placeholder="Preparation" name="preparation" onChange={event => handlePreparedIngredientChange(index, event)} defaultValue={element.preparation} /> */}
                            <br />
                        </div>)
                })}
                <button onClick={addAnotherIngredient}>Add another ingredient</button>
                <br />
                <button type="submit">Submit ingredients</button>
                </form>

                {/* TAGS */}
                <br />
                <br />
                <p>Add tag:</p>
                    <form>
                <select name="tags" onChange={handleTags} defaultValue="select-tag">
                    <option disabled value="select-tag">Select a tag</option>
                    {tagsOptions}
                </select>

                {/* INSTRUCTIONS */}
                <br />
                <br />
                <p>Add instruction:</p>
                <input type="text" placeholder="Instructions" name="instructions" onChange={handleInstructions} defaultValue={recipe.instructions} />
                </form>

                <br />
                <br />
            
                <button onClick={handleSubmit}>Create Recipe</button>
        </div>
    )
}

export default RecipeForm;