package com.meals.api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meals.api.domain.Meal;

import com.meals.api.repositories.MealRepository;

@Service
public class MealService {

    /*
     * Criação da classe MealService, que contém os métodos para salvar,
     * deletar,
     * buscar e atualizar uma refeição no banco de dados
     * A classe é anotada com @Service para indicar que é um serviço
     */

    @Autowired
    private MealRepository mealRepository;

    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    public void delete(Long id) {
        mealRepository.deleteById(id);
    }

    public Optional<Meal> findById(Long id) {
        return mealRepository.findById(id);
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    public int update(Long id, String name, String ingredients, BigDecimal cost, int restaurantId) {
        return mealRepository.updateMeal(id, name, ingredients, cost, restaurantId);
    }
}
