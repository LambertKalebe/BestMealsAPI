/*
 * Entidade da avaliação de restaurantes
 * A avaliação é composta por um id, id do restaurante, nota e comentário
 * a nota é limitada a 5
 */

package com.meals.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurantevaluation")
public class RestauranteEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o ID
    private Long id;
    public Long idRestaurante;
    public int evaluation;
    public String comment;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
