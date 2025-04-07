package com.meals.api.repositories;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meals.api.domain.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    /*
     * Método para atualizar uma refeição no banco de dados
     * O método é anotado com @Modifying e @Transactional para indicar que é uma
     * operação de modificação
     */

    @Transactional
    @Modifying
    @Query("UPDATE Meal r SET r.name = :name, r.ingredients = :ingredients, r.cost = :cost, r.restaurantId = :restaurantId WHERE r.id = :id")
    int updateMeal(Long id, String name, String ingredients, BigDecimal cost, int restaurantId);
}