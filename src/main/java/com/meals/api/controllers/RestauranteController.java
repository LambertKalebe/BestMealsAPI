/*Explicação breve do codigo
 * Ele controla os Request caso o usuario use a url /restaurants ele retorna um "guia" com as funcoes da API
 * Ele tem 4 funcoes principais:
 * - Criar um restaurante
 * - Atualizar um restaurante
 * - Deletar um restaurante
 * - Listar todos os restaurantes ou um especifico
*/

package com.meals.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.Restaurante;
import com.meals.api.services.RestauranteService;

@RestController
@RequestMapping("/restaurants")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public Object getIndex() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "API de Restaurantes";
            @SuppressWarnings("unused")
            public final String[] endpoints = {
                    "POST /create: Criar um novo restaurante",
                    "POST /update: Atualizar um restaurante existente",
                    "POST /delete: Deletar um restaurante",
                    "GET /find/{id}: Lista um restaurante específico por id, caso nenhum id seja passado, lista todos os restaurantes"
            };
        };
    }

    // Criação do restaurante
    @PostMapping("/create")
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        return restauranteService.save(restaurante);
    }

    @GetMapping("/create")
    public Object getCreateExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para criar um restaurante";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /restaurants/create";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final String nome = "Restaurante Exemplo";
                public final String endereco = "Rua Exemplo, 123";
                public final String telefone = "123456789";
            };
        };
    }

    // Atualização do restaurante
    @PostMapping("/update/{id}")
    public Restaurante update(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        int rowsUpdated = restauranteService.update(id, restaurante.getNome(), restaurante.getEndereco(),
                restaurante.getTelefone());
        if (rowsUpdated > 0) {
            return restauranteService.findById(id).orElse(null);
        }
        return null;
    }

    @GetMapping("/update")
    public Object getUpdateExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para atualizar um restaurante";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /restaurants/update/{id}";
            @SuppressWarnings("unused")
            public final String contentType = "application/json";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final String nome = "Restaurante Atualizado";
                public final String endereco = "Rua Atualizada, 456";
                public final String telefone = "987654321";
            };
        };
    }

    // Exclusão do restaurante
    @PostMapping("/delete")
    public void deleteRestaurante(@RequestBody Restaurante restaurante) {
        restauranteService.delete(restaurante);
    }

    @GetMapping("/delete")
    public Object getDeleteExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para deletar um restaurante";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /restaurants/delete";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final Long id = 1L;
            };
        };
    }

    // Listagem de restaurantes
    @GetMapping("/find")
    public Object findAllRestaurantes() {
        return restauranteService.findAll();
    }

    @GetMapping("/find/{id}")
    public Object findRestauranteById(@PathVariable Long id) {
        return restauranteService.findById(id).orElse(null);
    }
}