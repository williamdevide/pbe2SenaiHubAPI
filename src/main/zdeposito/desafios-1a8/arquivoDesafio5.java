package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio5 {
    
    @GetMapping("/desafio5")
    public String desafio5(
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) String idade) {
        try {
            String mensagem;
            if (nome == null || nome.isEmpty()) {
                mensagem = "Olá, você não informou seu nome.";
                return mensagem;
            }
            if (idade == null || idade.isEmpty()) {
                mensagem = "Olá, você não informou sua idade.";
                return mensagem;
            }
        
            int idadeInt = Integer.parseInt(idade);

            if (idadeInt >= 0 && idadeInt <= 12) {
                mensagem = nome + " você é Criança";
            } else if (idadeInt >= 13 && idadeInt <= 17) {
                mensagem = nome + " você é Adolescente";
            } else if (idadeInt >= 18 && idadeInt <= 64) {
                mensagem = nome + " você é Adulto";
            } else if (idadeInt >= 65 && idadeInt <= 100) {
                mensagem = nome + " você é Idoso";
            } else {
                mensagem = nome + " Idade inválida.";
            }
            return mensagem;
        } catch (Exception e) {
            String mensagem;
            mensagem = nome + " Idade inválida.";
            return mensagem;
        }
    }
}