/*
 * Controlador de rotas GET e POST para a API de Avaliação de Restaurantes
 * Apenas duas funções: criar e listar avaliações
 */

package com.meals.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.RestaurantEvaluation;
import com.meals.api.services.RestaurantEvaluationService;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}")
public class RestaurantEvaluationController {

    private final RestaurantEvaluationService restaurantEvaluationService;

    public RestaurantEvaluationController(RestaurantEvaluationService restaurantEvaluationService) {
        this.restaurantEvaluationService = restaurantEvaluationService;
    }

    @GetMapping("/avarage-evaluations")
    public Double restaurantAverageEvaluation(@PathVariable int restaurantId) {
        return restaurantEvaluationService.restaurantAverageEvaluation(restaurantId);
    }

    @GetMapping("/evaluations")
    public Object getRestaurantEvaluation(@PathVariable int restaurantId) {
        return restaurantEvaluationService.findByRestaurantId(restaurantId);
    }

    @PostMapping("/evaluations")
    public RestaurantEvaluation createRestauranteEvaluation(@PathVariable int restaurantId,
            @RequestBody RestaurantEvaluation restaurantEvaluation) {
        restaurantEvaluation.setRestaurantId(restaurantId);
        return restaurantEvaluationService.save(restaurantEvaluation);

    }
}
