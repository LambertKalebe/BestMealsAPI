package com.meals.api.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.Meal;
import com.meals.api.services.MealService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/meals")
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping()
    public List<Meal> findAll() {
        return mealService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Meal> findById(@PathVariable int id) {
        return mealService.findById(id);
    }

    @PostMapping()
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    @PutMapping("/{id}")
    public Meal updateMeal(@PathVariable int id, @RequestBody Meal meal) {
        mealService.update(id,
                meal.getName(),
                meal.getIngredients(),
                meal.getCost(),
                meal.getRestaurantId());
        return mealService.findById(id).orElse(null); // Retorna a refeição atualizada
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        mealService.delete(id);
        return "Refeição deletada com sucesso!";
    }

}