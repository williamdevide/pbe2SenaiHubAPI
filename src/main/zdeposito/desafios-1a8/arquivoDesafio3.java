package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio3 {
    
    @GetMapping("/desafio3")
    public String desafio3(@RequestParam String nome) {
        String mensagem;
        mensagem = nome + ", parabéns. Agora você utilizou um endpoint fixo.";
        return mensagem;
    }
}