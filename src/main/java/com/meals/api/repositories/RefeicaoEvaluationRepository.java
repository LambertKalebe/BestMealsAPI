package com.meals.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meals.api.domain.RefeicaoEvaluation;

@Repository
public interface RefeicaoEvaluationRepository extends JpaRepository<RefeicaoEvaluation, Long> {
    @SuppressWarnings("null")
    Optional<RefeicaoEvaluation> findById(Long id);

    @SuppressWarnings("null")
    List<RefeicaoEvaluation> findAll();

}
