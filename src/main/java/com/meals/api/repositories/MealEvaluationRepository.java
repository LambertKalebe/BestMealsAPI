package com.meals.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meals.api.domain.MealEvaluation;

@Repository
public interface MealEvaluationRepository extends JpaRepository<MealEvaluation, Integer> {
    List<MealEvaluation> findByMealId(int mealId);

    @Query("SELECT AVG(e.evaluation) FROM MealEvaluation e WHERE e.mealId = :mealId")
Double mealAverageEvaluation(int mealId);
}
