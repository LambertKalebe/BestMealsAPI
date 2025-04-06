/*
 * DTO (Data Transfer Object) para atualização de refeições.
 * Contém informações sobre o nome da refeição e uma lista de restaurantes com seus respectivos preços.
 * Criação da classe RestaurantePrecoDTO, que contém o id do restaurante e o preço.
 * Esta classe é utilizada para transferir dados entre a camada de controle e a camada de serviço.
 */

package com.meals.api.dtos;

import java.util.List;

public class RefeicaoUpdateDTO {
    private String nome;
    private List<RestaurantePrecoDTO> restaurantes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<RestaurantePrecoDTO> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(List<RestaurantePrecoDTO> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public static class RestaurantePrecoDTO {
        private Long id;
        private String preco;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPreco() {
            return preco;
        }

        public void setPreco(String preco) {
            this.preco = preco;
        }
    }
}