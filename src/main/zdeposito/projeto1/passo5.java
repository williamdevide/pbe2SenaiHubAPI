package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo5 {
    
    @GetMapping("/perfil3")
    public String perfil3(
        @RequestParam String nome,
        @RequestParam (required = false) String  sexo,
        @RequestParam (required = false) String idade
        ) {

        String mensagem;
        mensagem = "Olá, " + nome + " você é do sexo " 
            + sexo + " e tem " + idade + " anos de idade.";
        mensagem = mensagem.toUpperCase();     // maiusculo
        mensagem = mensagem.toLowerCase();     // minusculo
        mensagem = mensagem.trim();            // limpar espaços
        mensagem = mensagem.concat(" Para finalizar ADEUS!!!");
        mensagem = mensagem.replace("é do sexo null","não informou seu sexo");
        mensagem = mensagem.replace("e tem null anos de idade", "e não informou a sua idade");

        return mensagem;
    }
}
