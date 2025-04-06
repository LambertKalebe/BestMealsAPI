/*
 * Service Class do Restaurant
 * Contem os metodos para manipulacao dos dados do restaurante
 * * Métodos:
 * - Salvar um restaurante
 * - Deletar um restaurante
 * - Listar todos os restaurantes ou um especifico
 * - Atualizar um restaurante
 * Funciona meio que como um intermediario entre o controller e o repository
 */

package com.meals.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meals.api.domain.Restaurant;
import com.meals.api.repositories.RestaurantRepository;

@Service
public class RestaurantService {
    @Autowired
    public RestaurantRepository restauranteRepository;

    public Restaurant save(Restaurant restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public void delete(Long id) {
        restauranteRepository.deleteById(id);
    }

    public Optional<Restaurant> findById(Long id) {
        return restauranteRepository.findById(id);
    }

    @Transactional
    public int updateRestaurant(Long id, String name, String addres, String city, String state, String zipCode) {
        return restauranteRepository.updateRestaurant(id, name, addres, city, state, zipCode);
    }

    public List<Restaurant> findAll() {
        return restauranteRepository.findAll();
    }

    public Restaurant getReferenceById(Long id) {
        return restauranteRepository.getReferenceById(id);
    }
}
