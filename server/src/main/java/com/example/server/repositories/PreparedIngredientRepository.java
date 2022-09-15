package com.example.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.server.models.PreparedIngredient;

public interface PreparedIngredientRepository extends JpaRepository<PreparedIngredient, Long> {
}
