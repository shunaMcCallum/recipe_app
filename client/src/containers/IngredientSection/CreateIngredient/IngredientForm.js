import React, { useEffect, useState } from 'react';
import Request from '../../../helpers/request';

const IngredientForm = ({ onCreate }) => {
    
    const [types, setTypes] = useState([]);
    const [measurementTypes, setMeasurementTypes] = useState([]);
    
    const [ingredient, setIngredient] = useState({});

    // fetch eNums from backend
    useEffect(() => {
        getTypes();
    }, [])

    useEffect(() => {
        getMeasurementTypes();
    }, [])

    const getTypes = () => {
        Request.get('http://localhost:8080/ingredient_types')
            .then(typeData => setTypes(typeData));
    }

    const getMeasurementTypes = () => {
        Request.get('http://localhost:8080/measurements')
            .then(measurementData => setMeasurementTypes(measurementData));
    }


    // handle form events
    const handleChange = (event) => {
        let propertyName = event.target.name;
        let copiedIngredient = { ...ingredient }
        copiedIngredient[propertyName] = event.target.value;
        setIngredient(copiedIngredient)
    }

    const handleType = function (event) {
        const index = parseInt(event.target.value)
        const selectedType = types[index]
        let copiedIngredient = { ...ingredient };
        copiedIngredient['type'] = selectedType
        setIngredient(copiedIngredient)
    }

    const handleMeasurementType = function (event) {
        const index = parseInt(event.target.value)
        const selectedMeasurementType = measurementTypes[index]
        let copiedIngredient = { ...ingredient };
        copiedIngredient['measurement_type'] = selectedMeasurementType
        setIngredient(copiedIngredient)
    }

    const handleSubmit = function (event) {
        event.preventDefault();
        onCreate(ingredient);
    }

    const typeOptions = types.map((type, index) => {
        return <option key={index} value={index}>{type}</option>
    })

    const measurementTypeOptions = measurementTypes.map((measurement_type, index) => {
        return <option key={index} value={index}>{measurement_type}</option>
    })

    return (
        <div className="ingredient-form">
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Ingredient Name" name="name" onChange={handleChange} defaultValue={ingredient.name} />
                <select name="type" onChange={handleType} defaultValue="select-type">
                    <option disabled value="select-type">Select an ingredient type</option>
                        {typeOptions}
                </select>
                <input type="number" step="0.01" placeholder="Number of Calories" name="calories" onChange={handleChange} defaultValue={ingredient.calories} />
                <input type="number" placeholder="Measurement" name="measurement" onChange={handleChange} defaultValue={ingredient.measurement} />
                <select name="measurement_type" onChange={handleMeasurementType} defaultValue="select-measurement-type">
                    <option disabled value="select-measurement-type">Select a measurement type</option>
                    {measurementTypeOptions}
                </select>
                <button type="submit">Save</button>
            </form>

        </div>
    )
}

export default IngredientForm;