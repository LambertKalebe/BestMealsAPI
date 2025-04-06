/*
 * Criação da interface RefeicaoRepository, que estende a interface JpaRepository
 * Feita para realizar operações CRUD na entidade Refeicao
 * Métodos: updateRefeicao, delete, findById, findAll
 */

package com.meals.api.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meals.api.domain.Refeicao;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Long> {

    // Método para atualizar o nome da refeição
    // O método updateRefeicao recebe o id da refeição e o novo nome

    @Transactional
    @Modifying
    @Query("UPDATE Refeicao r SET r.nome = :nome WHERE r.id = :id")
    void updateRefeicao(@Param("id") Long id, @Param("nome") String nome);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM refeicao_restaurante WHERE refeicao_id = :refeicaoId", nativeQuery = true)
    void deleteRefeicaoRestaurantes(Long refeicaoId);

    // Método para inserir uma refeição e um restaurante na tabela intermediária
    // O método insertRefeicaoRestaurante recebe o id da refeição, o id do
    // restaurante e o preço
    @Modifying
    @Query(value = "INSERT INTO refeicao_restaurante (refeicao_id, restaurante_id, preco) VALUES (:refeicaoId, :restauranteId, :preco)", nativeQuery = true)
    void insertRefeicaoRestaurante(Long refeicaoId, Long restauranteId, BigDecimal preco);

    // Método para deletar uma refeição e um restaurante na tabela intermediária
    void delete(@SuppressWarnings("null") Refeicao refeicao);

    // Método para encontrar uma refeição pelo id
    @SuppressWarnings("null")
    Optional<Refeicao> findById(@SuppressWarnings("null") Long id);

    // Método para encontrar todas as refeições
    @SuppressWarnings("null")
    List<Refeicao> findAll();
}