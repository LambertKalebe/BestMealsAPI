package com.meals.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.MealEvaluation;
import com.meals.api.services.MealEvaluationService;

@RestController
@RequestMapping("/api/meals/{mealId}")
public class MealEvaluationController {
    private final MealEvaluationService mealEvaluationService;

    public MealEvaluationController(MealEvaluationService mealEvaluationService) {
        this.mealEvaluationService = mealEvaluationService;
    }

    @GetMapping("/evaluations")
    public Object getMealEvaluations(@PathVariable int mealId) {
        return mealEvaluationService.findByMealId(mealId);
    }

    @PostMapping("/evaluations")
    public Object createMealEvaluation(@PathVariable int mealId, @RequestBody MealEvaluation mealEvaluation) {
        mealEvaluation.setMealId(mealId);
        return mealEvaluationService.save(mealEvaluation);

    }

    @GetMapping("/avarage-evaluations")
    public Double mealAverageEvaluation(@PathVariable int mealId) {
        return mealEvaluationService.mealAverageEvaluation(mealId);
    }
}
