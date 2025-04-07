/*
 * Repositorioio de Avaliação de Restaurantes
 * Como as avaliações são simples, foi apenas necessario definir os Finders
 * para buscar as avaliações por id e listar todas as avaliações
 */

package com.meals.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.meals.api.domain.RestaurantEvaluation;

@Repository
public interface RestaurantEvaluationRepository extends JpaRepository<RestaurantEvaluation, Integer> {
    @Query("SELECT AVG(e.evaluation) FROM RestaurantEvaluation e WHERE e.restaurantId = :restaurantId")
    Double restaurantAverageEvaluation(int restaurantId);
}
