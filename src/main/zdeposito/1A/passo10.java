package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.util.LinkedHashMap;

@RestController
public class passo10{
    private List<Map<String, String>> alunos =
    List.of(
        new LinkedHashMap<String, String>() {{
            put("nome", "William");
            put("idade", "43");
            put("email", "william@gmail.com");
        }},
        new LinkedHashMap<String, String>() {{
            put("nome", "Mariana");
            put("idade", "33");
            put("email", "mariana@gmail.com");
        }},
        new LinkedHashMap<String, String>() {{
            put("nome", "Edivan");
            put("idade", "40");
            put("email", "edivan@gmail.com");
        }},
        new LinkedHashMap<String, String>() {{
            put("nome", "João");
            put("idade", "25");
            put("email", "joao@gmail.com");
        }},
        new LinkedHashMap<String, String>() {{
            put("nome", "Renan");
            put("idade", "37");
            put("email", "renan@gmail.com");
        }}
    );

    @GetMapping("/exibiralunos")
    public List<Map<String, String>> json3() {
        return alunos;
    }    
    
    @GetMapping("/aluno/{nome}")
    public Map<String, String> json4
    (@PathVariable String nome) {
        for (Map<String, String> aluno : alunos) {
            if(aluno.get("nome").equalsIgnoreCase(nome))
            return aluno;
        }
        
        return Map.of("erro", "Aluno não encontrado");
    }

    @GetMapping("/aluno2")
    public Map<String, String> json5
    (@RequestParam (required = false) String nome) {

        if (nome != null ) {

            Optional<Map<String, String>> aluno = alunos.stream().filter(a -> a.get("nome")
                .equalsIgnoreCase(nome)).findFirst();
            
            return aluno.orElse(Map.of("erro","Aluno não encontrado"));
        
        } else {
            return Map.of("erro", "Aluno não informado");
        }

        
    }
}