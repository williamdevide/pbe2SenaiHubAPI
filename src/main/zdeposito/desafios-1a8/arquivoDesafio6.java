package com.example.projeto1;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class arquivoDesafio6 {
    
    @GetMapping("/desafio6/{nome}")
    public Map<String, String> desafio6(
        @PathVariable(required = false) String nome) {
        
        Map<String, String> mensagem;

        if (nome == null || nome.isEmpty()) {
            mensagem = Map.of("erro", "NOME NÃO INFORMADO");
        } else {
            mensagem = Map.of("nome", nome);
        }

        return mensagem;
    }
}