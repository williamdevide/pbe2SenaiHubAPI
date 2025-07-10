package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo2 {
    
    @GetMapping("/hello/{nome}")
    public String helloComNomeComVariavel(@PathVariable String nome) {
        return "Olá, " + nome;
    }
}
