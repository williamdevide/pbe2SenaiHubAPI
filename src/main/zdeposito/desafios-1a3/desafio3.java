package com.example.projeto1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
public class desafio3 {

    private List<Map<String, String>> alunos = List.of(
        Map.of("nome", "João Silva", "curso", "Spring Boot", "idade", "25", "email", "joao.silva@email.com"),
        Map.of("nome", "Maria Oliveira", "curso", "Java", "idade", "28", "email", "maria.oliveira@email.com"),
        Map.of("nome", "Pedro Souza", "curso", "Spring Framework", "idade", "30", "email", "pedro.souza@email.com")
    );

    @GetMapping("/desafio3")
    public List<Map<String, String>> buscarAluno(
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