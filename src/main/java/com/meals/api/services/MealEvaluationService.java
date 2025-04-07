package com.meals.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meals.api.domain.MealEvaluation;
import com.meals.api.repositories.MealEvaluationRepository;

@Service
public class MealEvaluationService {
    @Autowired
    private MealEvaluationRepository mealEvaluationRepository;

    public MealEvaluation save(MealEvaluation mealEvaluation) {
        return mealEvaluationRepository.save(mealEvaluation);
    }

    public List<MealEvaluation> findByMealId(int mealId) {
        return mealEvaluationRepository.findByMealId(mealId);
    }

    public List<MealEvaluation> findAll() {
        return mealEvaluationRepository.findAll();
    }
}
