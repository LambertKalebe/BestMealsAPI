//Possivel má otimização (requer uma melhoria no código?):

package com.meals.api.controllers;

import java.util.List;
import java.util.Map;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meals.api.domain.Refeicao;
import com.meals.api.dtos.RefeicaoUpdateDTO;
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
    @SuppressWarnings("unchecked")
    @PostMapping("/create")
    public Refeicao createRefeicao(@RequestBody Map<String, Object> payload) {
        String nome = (String) payload.get("nome");
        List<Map<String, Object>> restaurantes = (List<Map<String, Object>>) payload.get("restaurantes");
        return refeicaoService.save(nome, restaurantes);
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
    public ResponseEntity<Refeicao> update(@PathVariable Long id, @RequestBody RefeicaoUpdateDTO dto) {
        try {
            List<Map<String, Object>> restaurantes = dto.getRestaurantes().stream().map(rest -> {
                Map<String, Object> map = new java.util.HashMap<>();
                map.put("id", rest.getId());
                map.put("preco", rest.getPreco());
                return map;
            }).toList();

            refeicaoService.updateRefeicaoCompleta(id, dto.getNome(), restaurantes);

            Optional<Refeicao> refeicaoAtualizada = refeicaoService.findById(id);
            return refeicaoAtualizada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
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