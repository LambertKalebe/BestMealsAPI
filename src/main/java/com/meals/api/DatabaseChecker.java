package com.meals.api;

import javax.sql.DataSource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class DatabaseChecker {
    private final DataSource dataSource;

    // Construtor corrigido
    public DatabaseChecker(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping
    public String checkDatabaseConnection() {
        try (java.sql.Connection connection = dataSource.getConnection()) {
            return "Banco de dados conectado";
        } catch (Exception e) {
            return "Erro ao conectar ao banco de dados: " + e.getMessage();
        }
    }
}