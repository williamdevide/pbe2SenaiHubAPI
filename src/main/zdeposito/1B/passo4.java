package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo4 {
    
    @GetMapping("/perfil2")
    public String perfil2(
        @RequestParam String nome,
        @RequestParam (required = false) String sexo,
        @RequestParam (required = false) String idade
        ) {
        return "Olá, " + nome + " você é do sexo " 
            + sexo + " e tem " + idade + " anos de idade.";
    }
}
