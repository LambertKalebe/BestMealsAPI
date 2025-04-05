//Possivel má otimização (requer uma melhoria no código?):

package com.meals.api.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.Refeicao;
import com.meals.api.services.RefeicaoService;

@RestController
@RequestMapping("/meals")
public class RefeicaoController {
    private final RefeicaoService refeicaoService;

    public RefeicaoController(RefeicaoService refeicaoService) {
        this.refeicaoService = refeicaoService;
    }

    @GetMapping
    public Object getIndex() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "API de Refeições";
            @SuppressWarnings("unused")
            public final String[] endpoints = {
                    "POST /create: Criar uma nova refeição",
                    "POST /update: Atualizar uma refeição existente",
                    "POST /delete: Deletar uma refeição",
                    "GET /find/{id}: Lista uma refeição específica por id, caso nenhum id seja passado, lista todas as refeições"
            };
        };
    }

    // Criação da refeição
    @PostMapping("/create")
    public Refeicao createRefeicao(@RequestBody Map<String, Object> payload) {
        String nome = (String) payload.get("nome");
        return refeicaoService.save(nome);
    }

    @GetMapping("/create")
    public Object getCreateExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para criar uma refeição com múltiplos restaurantes";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /meals/create";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final String nome = "Bife";
                public final Object[] restaurantes = {
                        new Object() {
                            public final Long id = 1L;
                            public final String preco = "21.23";
                        },
                        new Object() {
                            public final Long id = 2L;
                            public final String preco = "21.33";
                        }
                };
            };
        };
    }

    // Atualização da refeição
    @PostMapping("/update/{id}")
    public Refeicao update(@PathVariable Long id, @RequestBody Refeicao refeicao) {
        int rowsUpdated = refeicaoService.update(id, refeicao.getNome());
        if (rowsUpdated > 0) {
            return refeicaoService.findById(id).orElse(null);
        }
        return null;
    }

    @GetMapping("/update")
    public Object getUpdateExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para atualizar uma refeição";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /meals/update/{id}";
            @SuppressWarnings("unused")
            public final String contentType = "application/json";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final String nome = "Refeição Atualizada";
                public final String preco = "29.99";
            };
        };
    }

    // Exclusão da refeição
    @PostMapping("/delete")
    public void deleteRefeicao(@RequestBody Refeicao refeicao) {
        refeicaoService.delete(refeicao);
    }

    @GetMapping("/delete")
    public Object getDeleteExample() {
        return new Object() {
            @SuppressWarnings("unused")
            public final String descricao = "Exemplo de POST para deletar uma refeição";
            @SuppressWarnings("unused")
            public final String endpoint = "POST /meals/delete";
            @SuppressWarnings("unused")
            public final Object exemplo = new Object() {
                public final Long id = 1L;
            };
        };
    }

    // Listagem de refeições
    @GetMapping("/find")
    public Object findAllRefeicoes() {
        return refeicaoService.findAll();
    }

    @GetMapping("/find/{id}")
    public Object findRefeicaoById(@PathVariable Long id) {
        return refeicaoService.findById(id);
    }
}