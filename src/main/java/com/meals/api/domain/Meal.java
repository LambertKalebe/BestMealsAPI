package com.meals.api.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Meal {

    /*
     * Criação da classe Meal, que representa a entidade Refeicao
     * A classe contém os atributos id, name, cost, ingredients e restaurantId
     * A classe também contém os métodos getters e setters para cada atributo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String name;

    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost;

    public String ingredients;
    public int restaurantId;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}