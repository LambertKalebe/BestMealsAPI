package com.meals.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meals.api.domain.RefeicaoEvaluation;
import com.meals.api.repositories.RefeicaoEvaluationRepository;

@Service
public class RefeicaoEvaluationService {
    @Autowired
    private RefeicaoEvaluationRepository refeicaoEvaluationRepository;

    public RefeicaoEvaluation save(RefeicaoEvaluation refeicaoEvaluation) {
        return refeicaoEvaluationRepository.save(refeicaoEvaluation);
    }

    public Optional<RefeicaoEvaluation> findById(Long id) {
        return refeicaoEvaluationRepository.findById(id);
    }

    public List<RefeicaoEvaluation> findAll() {
        return refeicaoEvaluationRepository.findAll();
    }

    public Double getAverageEvaluationByMealId(Long idMeal) {
        return refeicaoEvaluationRepository.findAverageEvaluationByMealId(idMeal);
    }
}
