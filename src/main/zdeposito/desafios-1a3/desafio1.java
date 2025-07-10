package com.example.projeto1;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class desafio1 {

    @GetMapping("/desafio1/{nome}")
    public Map<String, String> desafioJson(@PathVariable String nome) {
        
        if (nome == null) {
            return Map.of("erro", "Nome não fornecido!");
        }

        return Map.of("nome", nome);
    }
}