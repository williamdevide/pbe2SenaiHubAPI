package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo3 {
    
    @GetMapping("/perfil")
    public String perfil(
        @RequestParam String nome,
        @RequestParam String sexo,
        @RequestParam String idade
        ) {
        return "Olá, " + nome + " você é do sexo " 
            + sexo + " e tem " + idade + " anos de idade.";
    }
}
