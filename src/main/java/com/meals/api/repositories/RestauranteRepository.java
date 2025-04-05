/*
 * Criação da interface RestauranteRepository, que estende a interface JpaRepository
 * Feita para realizar operações CRUD na entidade Restaurante
 * Métodos: updateRestaurante, delete, findById, findAll
 */

package com.meals.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meals.api.domain.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Modifying
    @Query("UPDATE Restaurante r SET r.nome = :nome, r.endereco = :endereco, r.telefone = :telefone WHERE r.id = :id")
    int updateRestaurante(Long id, String nome, String endereco, String telefone);

    void delete(Restaurante restaurante);

    Optional<Restaurante> findById(Long id);

    List<Restaurante> findAll();
}
