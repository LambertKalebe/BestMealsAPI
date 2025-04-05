package com.meals.api.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "refeicoes")
public class Refeicao {

    // Simples, apenas o nome da refeição e o id dela
    // A refeição pode ter vários restaurantes, e o restaurante pode ter várias
    // refeições
    // Então, é uma relação muitos para muitos entre refeição e restaurante
    // Então decidi criar uma tabela intermediaria entre refeição e restaurante,
    // chamada refeicao_restaurante
    // Essa tabela intermediaria vai ter o id da refeição e o id do restaurante, e
    // vai ser uma relação muitos para muitos entre refeição e restaurante
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String nome;

    @ManyToMany
    @JoinTable(name = "refeicao_restaurante", joinColumns = @JoinColumn(name = "refeicao_id"), inverseJoinColumns = @JoinColumn(name = "restaurante_id"))
    private Set<Restaurante> restaurantes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}