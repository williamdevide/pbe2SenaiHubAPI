package com.example.projeto1;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste14 {

    private List<Map<String, String>> alunos = List.of(
        Map.of("nome", "João Silva", "curso", "Spring Boot", "idade", "25", "email", "joao.silva@email.com"),
        Map.of("nome", "Maria Oliveira", "curso", "Java", "idade", "28", "email", "maria.oliveira@email.com"),
        Map.of("nome", "Pedro Souza", "curso", "Spring Framework", "idade", "30", "email", "pedro.souza@email.com")
    );

	@GetMapping("/aluno7")
	public Map<String, String> aluno7(
        @RequestParam String nome
        ) {
		Optional<Map<String, String>> aluno = alunos.stream()
                .filter(a -> a.get("nome").equalsIgnoreCase(nome))
                .findFirst();

        return aluno.orElse(Map.of("erro", "Aluno não encontrado"));
	}
}

// http://localhost:8080/aluno5/nome/Maria oliveira