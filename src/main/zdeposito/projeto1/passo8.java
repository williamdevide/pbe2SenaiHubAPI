package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo8 {
    
    @GetMapping("/json1")
    public String json1() {
        String mensagem;

        mensagem = "{\"nome\":\"William\"}";

        return mensagem;
    }       
}
