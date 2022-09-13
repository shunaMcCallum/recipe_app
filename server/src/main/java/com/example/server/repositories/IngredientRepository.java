package com.example.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.server.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
