package com.meals.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.Restaurante;
import com.meals.api.services.RestauranteService;

@RestController
@RequestMapping("/restaurants")
class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.save(restaurante);
    }

    @GetMapping
    public List<Restaurante> getRestaurantes() {
        return restauranteService.findAll();
    }
}