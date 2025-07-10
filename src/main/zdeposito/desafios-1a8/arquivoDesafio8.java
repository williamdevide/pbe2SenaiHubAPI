package com.example.projeto1;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio8 {
    
    private List<Map<String, String>> alunos =
       List.of(
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com"),
            Map.of("nome","William", "idade", "43", "email", "william@gmail.com")
        );

    @GetMapping("/desafio8")
    public Map<String, String> desafio8(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) String idade,
        @RequestParam(required = false) String curso) {

        if (nome != null && !nome.isEmpty()) {
            return alunos.stream()
                .filter(a -> a.get("nome").equalsIgnoreCase(nome))
                .findFirst()
                .orElse(Map.of("erro", "nao encontrado"));
        } else if (idade != null && !idade.isEmpty()) {
            return alunos.stream()
                .filter(a -> a.get("idade").equals(idade))
                .findFirst()
                .orElse(Map.of("erro", "nao encontrado"));
        } else if (curso != null && !curso.isEmpty()) {
            return alunos.stream()
                .filter(a -> a.get("curso").equalsIgnoreCase(curso))
                .findFirst()
                .orElse(Map.of("erro", "nao encontrado"));
        }

        return Map.of("erro", "nenhum parametro informado");
    }
}