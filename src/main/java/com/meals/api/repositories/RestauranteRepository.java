package com.meals.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meals.api.domain.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Restaurante r SET r.nome = :#{#restaurante.nome}, r.endereco = :#{#restaurante.endereco}, r.refeicoes = :#{#restaurante.refeicoes}, r.telefone = :#{#restaurante.telefone} WHERE r.id = :#{#restaurante.id}")
    Restaurante update(Restaurante restaurante);
    // Posteriormente utilizar para atualizar um restaurante (Pagina de
    // atualização?)

    // Posteriormente utilizar para excluir um restaurante(Não é muito necessario
    // nesse caso)
    void delete(Restaurante restaurante);

    // Posteriormente utilizar para buscar um restaurante pelo id(possivelmente
    // alterar para buscar pelo nome)
    Optional<Restaurante> findById(Long id);

    // Posteriormente utilizar para listar todos os restaurantes na pagina
    List<Restaurante> findAll();
}
