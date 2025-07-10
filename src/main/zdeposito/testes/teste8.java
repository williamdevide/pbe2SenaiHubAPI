package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste8 {

	@GetMapping("/aluno1")
    public String aluno1() {
        return "{\"nome\": \"William Komel\"}";
    }
}

// http://localhost:8080/aluno1