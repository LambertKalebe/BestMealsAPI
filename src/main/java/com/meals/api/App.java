package com.meals.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AutoConfiguration
@SpringBootApplication(scanBasePackages = "com.meals.api")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}