package com.meals.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.meals.api.domain.Restaurante;

@Repository
public interface IRestauranteDAO {
    // Explicito
    Restaurante save(Restaurante restaurante);

    // Posteriormente utilizar para atualizar um restaurante (Pagina de
    // atualização?)
    Restaurante update(Restaurante restaurante);

    // Posteriormente utilizar para excluir um restaurante(Não é muito necessario
    // nesse caso)
    void delete(Restaurante restaurante);

    // Posteriormente utilizar para buscar um restaurante pelo id(possivelmente
    // alterar para buscar pelo nome)
    Restaurante findById(Long id);

    // Posteriormente utilizar para listar todos os restaurantes na pagina
    List<Restaurante> findAll();
}
