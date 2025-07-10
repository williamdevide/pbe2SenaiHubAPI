package com.example.projeto1;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste10 {

	@GetMapping("/aluno3")
	public List<Map<String, String>> aluno3() {
		return List.of(
            Map.of(
                "nome", "João Silva",
                "curso", "Spring Boot",
                "idade", "25",
                "email", "joao.silva@email.com"
            ),
            Map.of(
                "nome", "Maria Oliveira",
                "curso", "Java",
                "idade", "28",
                "email", "maria.oliveira@email.com"
            ),
            Map.of(
                "nome", "Pedro Souza",
                "curso", "Spring Framework",
                "idade", "30",
                "email", "pedro.souza@email.com"
            )
        );
	}
}

// http://localhost:8080/aluno3