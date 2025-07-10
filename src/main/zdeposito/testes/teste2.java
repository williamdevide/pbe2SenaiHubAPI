package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste2 {

	@GetMapping("/hello2/{nome}")
	public String hello2(@PathVariable String nome) {
    	return "Olá, " + nome + "! Bem-vindo ao SENAI!";
	}

}

 // http://localhost:8080/hello2/william