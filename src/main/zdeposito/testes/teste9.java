package com.example.projeto1;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste9 {

	@GetMapping("/aluno2")
	public Map<String, String> aluno2() {
		return Map.of("nome", "William Komel", "curso", "Spring Boot");
	}
}

// http://localhost:8080/aluno2