package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio2 {
    
    @GetMapping("/desafio2/{nome}")
    public String desafio2(@PathVariable String nome) {
        String mensagem;
        mensagem = nome + ", parabéns. Você utilizou um endpoint variável.";
        return mensagem;
    }
}