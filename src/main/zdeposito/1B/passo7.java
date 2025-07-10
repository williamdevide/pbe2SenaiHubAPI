package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo7 {
    
    @GetMapping("/periodo2/{hora}")
    public String periodo2(
        @PathVariable String hora
        ) {
        
        try {
            Integer horaInt;
            String mensagem;
            mensagem = "";
            horaInt = Integer.parseInt(hora);
            mensagem = switch (horaInt) {
                case 6, 7, 8, 9, 10, 11 -> "Bom dia";
                case 12, 13, 14, 15, 16, 17 -> "Boa tarde";
                case 18, 19, 20, 21, 22, 23, 0, 1, 2, 3, 4, 5 -> "Boa noite";
                default -> "Hora Inválida";
            };
            return mensagem;
            
        } catch (Exception e) {
            String mensagem;
            mensagem = "O valor informado não é uma hora válida.";
            return mensagem;
        }
    }
}
