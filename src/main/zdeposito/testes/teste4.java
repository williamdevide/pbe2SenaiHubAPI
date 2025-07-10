package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste4 {
    
    @GetMapping("/saudacao1")
    public String saudacao1(
        @RequestParam String nome,
        @RequestParam(required = false) String sobrenome) {
        
        if (sobrenome == null) {
            return "Olá, " + nome + "!";
        } else {
            return "Olá, " + nome + " " + sobrenome + "!";
        }
    }
}

// http://localhost:8080/saudacao1?nome=William&sobrenome=Komel