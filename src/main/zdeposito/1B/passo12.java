package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Optional;

@RestController
public class passo12 {
    
    private List<Map<String, String>> alunos =
        List.of(
            new LinkedHashMap<String, String>() {{
                put("nome", "William");
                put("idade", "43");
                put("email", "william@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Ana");
                put("idade", "30");
                put("email", "ana@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Carlos");
                put("idade", "25");
                put("email", "carlos@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Julia");
                put("idade", "28");
                put("email", "julia@gmail.com");
            }},
            new LinkedHashMap<String, String>() {{
                put("nome", "Felipe");
                put("idade", "35");
                put("email", "felipe@gmail.com");
            }}
        );

    @GetMapping("/exibiralunos")
    public List<Map<String, String>> json5() {
        return alunos;
    }

    @GetMapping("/pesquisaraluno/{nome}")
    public Map<String, String> json6(@PathVariable String nome) {
        for(Map<String, String> aluno : alunos) {
            if(aluno.get("nome").equals(nome)) {
                return aluno;
            }
        }
        return Map.of("erro","Aluno não encontrado");
    }

    @GetMapping("/pesquisaraluno2")
    public Map<String, String> json7(@RequestParam (required = false) String nome) {
        if (nome != null && !nome.isEmpty()) {
            Optional<Map<String, String>> aluno = alunos.stream().filter(a -> a.get("nome").equalsIgnoreCase(nome)).findFirst();
            return aluno.orElse(Map.of("erro","Aluno não encontrado"));
        } else {
            return Map.of("erro","Não foi informado o nome");
        }
    }
}
