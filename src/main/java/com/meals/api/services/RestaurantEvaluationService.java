/*
 * Service das avaliações de restaurantes.
 * Apenas duas funções: criar e listar avaliações
 */

package com.meals.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meals.api.domain.RestaurantEvaluation;
import com.meals.api.repositories.RestaurantEvaluationRepository;

@Service
public class RestaurantEvaluationService {

    @Autowired
    private RestaurantEvaluationRepository restaurantEvaluationRepository;

    public RestaurantEvaluation save(RestaurantEvaluation restaurantEvaluation) {
        return restaurantEvaluationRepository.save(restaurantEvaluation);
    }

    public List<RestaurantEvaluation> findByRestaurantId(int restaurantId) {
        return restaurantEvaluationRepository.findByRestaurantId(restaurantId);
    }

    public List<RestaurantEvaluation> findAll() {
        return restaurantEvaluationRepository.findAll();
    }

    public Double restaurantAverageEvaluation(int restaurantId) {
        return restaurantEvaluationRepository.restaurantAverageEvaluation(restaurantId);
    }
}
