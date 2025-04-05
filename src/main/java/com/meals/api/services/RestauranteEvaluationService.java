/*
 * Service das avaliações de restaurantes.
 * Apenas duas funções: criar e listar avaliações
 */

package com.meals.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meals.api.domain.RestauranteEvaluation;
import com.meals.api.repositories.RestauranteEvaluationRepository;

@Service
public class RestauranteEvaluationService {

    @Autowired
    private RestauranteEvaluationRepository restauranteEvaluationRepository;

    public RestauranteEvaluation save(RestauranteEvaluation restauranteEvaluation) {
        return restauranteEvaluationRepository.save(restauranteEvaluation);
    }

    public Optional<RestauranteEvaluation> findById(Long id) {
        return restauranteEvaluationRepository.findById(id);
    }

    public List<RestauranteEvaluation> findAll() {
        return restauranteEvaluationRepository.findAll();
    }
}
