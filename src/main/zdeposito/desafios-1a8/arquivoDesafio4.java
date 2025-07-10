package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio4 {
    
    @GetMapping("/desafio4")
    public String desafio4(
        @RequestParam String nome, 
        @RequestParam String cpf) {
        String mensagem;
        if (cpf.length()==11) {
            mensagem = nome + ", CPF válido.";
        } else {
            mensagem = nome + ", CPF inválido.";
        }
        return mensagem;
    }
}