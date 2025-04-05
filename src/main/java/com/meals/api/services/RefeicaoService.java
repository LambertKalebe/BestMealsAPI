/*
 * Service Class do Refeicao
 * Contem os metodos para manipulacao dos dados do refeicao
 * save, delete, findById, update, findAll
 * Funciona meio que como um intermediario entre o controller e o repository
 */

package com.meals.api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meals.api.domain.Refeicao;

import com.meals.api.repositories.RefeicaoRepository;

@Service
public class RefeicaoService {
    @Autowired
    private RefeicaoRepository refeicaoRepository;

    // Cria a nova refeição
    @Transactional
    public Refeicao save(String nome, List<Map<String, Object>> restaurantes) {
        // Cria a nova refeição
        Refeicao refeicao = new Refeicao();
        refeicao.setNome(nome);
        Refeicao savedRefeicao = refeicaoRepository.save(refeicao);

        // Insere os dados na tabela intermediária refeicao_restaurante
        for (Map<String, Object> restaurante : restaurantes) {
            Long restauranteId = ((Number) restaurante.get("id")).longValue();
            BigDecimal preco = new BigDecimal(restaurante.get("preco").toString());
            refeicaoRepository.insertRefeicaoRestaurante(savedRefeicao.getId(), restauranteId, preco);
        }

        return savedRefeicao;
    }

    public void delete(Refeicao refeicao) {
        refeicaoRepository.delete(refeicao);
    }

    public Optional<Refeicao> findById(Long id) {
        return refeicaoRepository.findById(id);
    }

    @Transactional
    public int update(Long id, String nome) {
        return refeicaoRepository.updateRefeicao(id, nome);
    }

    public List<Refeicao> findAll() {
        return refeicaoRepository.findAll();
    }
}
