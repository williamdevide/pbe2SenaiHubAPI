package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo7 {
    
    @GetMapping("/saudacao2/{hora}")
    public String saudacao2(
        @PathVariable String hora
        ) {
        
        try {
            Integer horaInt;
            horaInt = Integer.parseInt(hora);

            String mensagem;
           
            mensagem = switch (horaInt) {
                case 6, 7, 8, 9, 10, 11 -> "Bom dia";
                case 12, 13, 14, 15, 16, 17 -> "Boa tarde";
                case 18, 19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5 -> "Boa noite";
                default -> "Hora inválida";
            };

            return mensagem;


        } catch (NumberFormatException e) {
            String mensagemErro;
            mensagemErro = "Você digitou algo errado.";
            return mensagemErro;            
        }

        
    }
}
