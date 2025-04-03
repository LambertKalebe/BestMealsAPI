package com.meals.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meals.api.domain.Restaurante;
import com.meals.api.repositories.RestauranteRepository;

@Service
public class RestauranteService {
    @Autowired
    public RestauranteRepository restauranteService;

    public Restaurante save(Restaurante restaurante) {
        return restauranteService.save(restaurante);
    }

    public void delete(Restaurante restaurante) {
        restauranteService.delete(restaurante);
    }

    public Optional<Restaurante> findById(Long id) {
        return restauranteService.findById(id);
    }

    public Restaurante update(Restaurante restaurante) {
        return restauranteService.update(restaurante);
    }

    public List<Restaurante> findAll() {
        return restauranteService.findAll();
    }
}
