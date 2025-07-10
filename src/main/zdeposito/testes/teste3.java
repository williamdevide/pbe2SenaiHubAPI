package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste3 {

	@GetMapping("/hello3")
	public String hello3(
		@RequestParam String nome
		) {
    	return "Olá, " + nome + "! Assim também somos bem-vindos ao SENAI!";
	}

}

// http://localhost:8080/hello3?nome=William