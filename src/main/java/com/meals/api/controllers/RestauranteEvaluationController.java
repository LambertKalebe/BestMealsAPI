/*
 * Controlador de rotas GET e POST para a API de Avaliação de Restaurantes
 * Apenas duas funções: criar e listar avaliações
 */

package com.meals.api.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.RestauranteEvaluation;
import com.meals.api.services.RestauranteEvaluationService;

@RestController
@RequestMapping("/restaurants/evaluation")
public class RestauranteEvaluationController {

    private final RestauranteEvaluationService restauranteEvaluationService;

    public RestauranteEvaluationController(RestauranteEvaluationService restauranteEvaluationService) {
        this.restauranteEvaluationService = restauranteEvaluationService;
    }

    @GetMapping
    public Object getIndex() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "API de Avaliação de Restaurantes";
            @SuppressWarnings("unused")
            public final String[] endpoints = {
                    "POST /create: Criar um novo restaurante",
                    "GET /find/{id}: Lista um restaurante específico por id, caso nenhum id seja passado, lista todos os restaurantes"
            };
        };
    }

    @GetMapping("/create")
    public Object getCreateExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para criar uma avalia o de um restaurante";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /restaurants/evaluation/create";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final Long idRestaurante = 1L;
                public final BigDecimal evaluation = BigDecimal.valueOf(4.5);
                public final String comment = "Um restaurante muito bom";
            };
        };
    }

    @PostMapping("/create")
    public RestauranteEvaluation createRestauranteEvaluation(@RequestBody RestauranteEvaluation restauranteEvaluation) {
        return restauranteEvaluationService.save(restauranteEvaluation);
    }

    @GetMapping("/find")
    public Object findAllRestaurantes() {
        return restauranteEvaluationService.findAll();
    }

    @GetMapping("/find/{id}")
    public Object findRestauranteById(@PathVariable Long id) {
        return restauranteEvaluationService.findById(id).orElse(null);
    }
}
