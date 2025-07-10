package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste5 {
    
    @GetMapping("/saudacao2")
    public String saudacao2(
        @RequestParam String nome,
        @RequestParam(required = false) String sobrenome) {
        
        String mensagem;

        if (sobrenome == null) {
            mensagem = "Olá, " + nome + "!";
        } else {
            mensagem = "Olá, " + nome + " " + sobrenome + "!";
        }

        return mensagem.toUpperCase();
    }
}

// http://localhost:8080/saudacao2?nome=William&sobrenome=Komel