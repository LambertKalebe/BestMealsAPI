package com.meals.api.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.RefeicaoEvaluation;
import com.meals.api.services.RefeicaoEvaluationService;

@RestController
@RequestMapping("/meals/evaluation")
public class RefeicaoEvaluationController {
    private final RefeicaoEvaluationService refeicaoEvaluationService;

    public RefeicaoEvaluationController(RefeicaoEvaluationService refeicaoEvaluationService) {
        this.refeicaoEvaluationService = refeicaoEvaluationService;
    }

    @GetMapping
    public Object getIndex() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "API de Avaliação de Refeições";
            @SuppressWarnings("unused")
            public final String[] endpoints = {
                    "POST /create: Criar uma nova avaliação de refeição",
                    "GET /find: Lista todas as avaliações de refeição",
                    "GET /find/{id}: Lista uma avaliação de refeição específica por id"
            };
        };
    }

    @GetMapping("/create")
    public Object getCreateExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final Long idRefeicao = 1L;
                public final BigDecimal evaluation = BigDecimal.valueOf(4.5);
                public final String comment = "Uma refeição muita boa";
            };
        };
    }

    @PostMapping("/create")
    public RefeicaoEvaluation createRefeicaoEvaluation(@RequestBody RefeicaoEvaluation refeicaoEvaluation) {
        return refeicaoEvaluationService.save(refeicaoEvaluation);
    }

    @GetMapping("/find")
    public Object findAllRestaurantes() {
        return refeicaoEvaluationService.findAll();
    }

    @GetMapping("/find/{id}")
    public Object findRestauranteById(@PathVariable Long id) {
        return refeicaoEvaluationService.findById(id).orElse(null);
    }
}
