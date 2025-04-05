/*
 * Service Class do Restaurante
 * Contem os metodos para manipulacao dos dados do restaurante
 * save, delete, findById, update, findAll
 * Funciona meio que como um intermediario entre o controller e o repository
 */

package com.meals.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meals.api.domain.Restaurante;
import com.meals.api.repositories.RestauranteRepository;

@Service
public class RestauranteService {
    @Autowired
    public RestauranteRepository restauranteRepository;

    public Restaurante save(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public void delete(Restaurante restaurante) {
        restauranteRepository.delete(restaurante);
    }

    public Optional<Restaurante> findById(Long id) {
        return restauranteRepository.findById(id);
    }

    @Transactional
    public int update(Long id, String nome, String endereco, String telefone) {
        return restauranteRepository.updateRestaurante(id, nome, endereco, telefone);
    }

    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }
}
