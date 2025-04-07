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
public class RestaurantEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o ID
    private int id;
    private int restaurantId; // Renomeado para seguir convenções de nomenclatura
    private int evaluation;
    private String comment;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRestaurantId() {
        return restaurantId;
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
