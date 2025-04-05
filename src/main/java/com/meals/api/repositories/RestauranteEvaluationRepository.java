/*
 * Repositorioio de Avaliação de Restaurantes
 * Como as avaliações são simples, foi apenas necessario definir os Finders
 * para buscar as avaliações por id e listar todas as avaliações
 */

package com.meals.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meals.api.domain.RestauranteEvaluation;

@Repository
public interface RestauranteEvaluationRepository extends JpaRepository<RestauranteEvaluation, Long> {

    Optional<RestauranteEvaluation> findById(Long id);

    List<RestauranteEvaluation> findAll();

}
