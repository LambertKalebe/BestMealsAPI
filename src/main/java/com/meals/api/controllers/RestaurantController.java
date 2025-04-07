/*Explicação breve do codigo
 * Ele controla os Request caso o usuario use a url /restaurants ele retorna um "guia" com as funcoes da API
 * Ele tem 4 funcoes principais:
 * - Criar um restaurante
 * - Atualizar um restaurante
 * - Deletar um restaurante
 * - Listar todos os restaurantes ou um especifico
*/

package com.meals.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.Restaurant;
import com.meals.api.repositories.RestaurantRepository;
import com.meals.api.services.RestaurantService;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restauranteService;

    public RestaurantController(RestaurantService restauranteService, RestaurantRepository restauranteRepository) {
        this.restauranteService = restauranteService;

    }

    @GetMapping()
    public List<Restaurant> getAll() {
        return restauranteService.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restauranteService.getReferenceById(id);
    }

    @PostMapping()
    public Restaurant createRestaurant(@RequestBody Restaurant restaurante) {
        return restauranteService.save(restaurante);
    }

    @PutMapping("/{id}")
    public Restaurant update(@PathVariable Long id, @RequestBody Restaurant restaurante) {
        int rowsUpdated = restauranteService.updateRestaurant(id,
                restaurante.getName(),
                restaurante.getAddress(),
                restaurante.getCity(),
                restaurante.getState(),
                restaurante.getZipCode());
        if (rowsUpdated > 0) {
            return restauranteService.findById(id).orElse(null);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        restauranteService.delete(id);
        return "success";
    }

}