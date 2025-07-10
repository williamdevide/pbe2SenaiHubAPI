package com.example.projeto1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
public class desafio4 {

    private List<Map<String, String>> alunos = List.of(
        new LinkedHashMap<>() {{
            put("nome", "João Silva");
            put("curso", "Spring Boot");
            put("idade", "25");
            put("email", "joao.silva@email.com");
        }},
        new LinkedHashMap<>() {{
            put("nome", "Maria Oliveira");
            put("curso", "Java");
            put("idade", "28");
            put("email", "maria.oliveira@email.com");
        }},
        new LinkedHashMap<>() {{
            put("nome", "Pedro Souza");
            put("curso", "Spring Framework");
            put("idade", "30");
            put("email", "pedro.souza@email.com");
        }},
        new LinkedHashMap<>() {{
            put("nome", "Ana Costa");
            put("curso", "Spring Boot");
            put("idade", "22");
            put("email", "ana.costa@email.com");
        }}
    );

    @GetMapping("/desafio4")
    public List<Map<String, String>> buscarAluno2(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) String curso,
        @RequestParam(required = false) String idade) {
    
        if (nome != null) {
            return alunos.stream()
                         .filter(a -> a.get("nome").equalsIgnoreCase(nome))
                         .collect(Collectors.toList());
        } else if (curso != null) {
            return alunos.stream()
                         .filter(a -> a.get("curso").equalsIgnoreCase(curso))
                         .collect(Collectors.toList());
        } else if (idade != null) {
            return alunos.stream()
                         .filter(a -> a.get("idade").equals(idade))
                         .collect(Collectors.toList());
        } else {
            return List.of();  // Caso nenhum parâmetro seja passado, retorna lista vazia
        }
    }
}