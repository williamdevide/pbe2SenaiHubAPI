package com.example.projeto1;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio7 {
    
    private List<Map<String, String>> alunos =
        List.of(
            Map.of("nome","William"),
            Map.of("nome","Mariana"),
            Map.of("nome","Edivan"),
            Map.of("nome","João"),
            Map.of("nome","Renan")
        );

    @GetMapping("/desafio7listar")
    public List<Map<String, String>> desafio7listar() {
        return alunos;
    }

    @GetMapping("/desafio7pesquisar")
    public Map<String, String> desafio7pesquisar(@RequestParam String nome) {
        for (Map<String, String> aluno : alunos) {
            if(aluno.get("nome").equalsIgnoreCase(nome))
            return aluno;
        }
        
        return Map.of("erro", "Aluno não encontrado");
    }
}