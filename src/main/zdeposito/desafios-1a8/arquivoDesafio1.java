package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio1 {
    
    @GetMapping("/desafio1")
    public String desafio1() {
        String mensagem;
        mensagem = "Seja bem vindo aos desafios de Backend.";
        return mensagem;
    }
}