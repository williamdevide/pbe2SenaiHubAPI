package com.example.projeto1;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste12 {

    private List<Map<String, String>> alunos = List.of(
        Map.of("nome", "João Silva", "curso", "Spring Boot", "idade", "25", "email", "joao.silva@email.com"),
        Map.of("nome", "Maria Oliveira", "curso", "Java", "idade", "28", "email", "maria.oliveira@email.com"),
        Map.of("nome", "Pedro Souza", "curso", "Spring Framework", "idade", "30", "email", "pedro.souza@email.com")
    );

	@GetMapping("/aluno5/{nome}")
	public Map<String, String> aluno5(@PathVariable String nome) {
		for (Map<String, String> aluno : alunos) {
            if (aluno.get("nome").equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return Map.of("erro", "Aluno não encontrado");
	}
}

// http://localhost:8080/aluno5/nome/Maria oliveira