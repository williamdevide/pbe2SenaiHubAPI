package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class passo6 {
    
    @GetMapping("/periodo1/{hora}")
    public String periodo1(
        @PathVariable String hora
        ) {
        
        try {
            Integer horaInt;
            String mensagem;
            mensagem = "";
            horaInt = Integer.parseInt(hora);
            if (horaInt >= 6 && horaInt < 12) {
                mensagem = "Bom dia";
            } else if (horaInt >= 12 && horaInt <18) {
                mensagem = "Boa tarde";
            } else if ((horaInt >= 18 && horaInt <=23) || (horaInt >= 0 && horaInt < 6)) {
                mensagem = "Boa noite";
            } else {
                mensagem = "Hora Inválida";
            }

            return mensagem;
        } catch (Exception e) {
            String mensagem;
            mensagem = "O valor informado não é uma hora válida.";
            return mensagem;
        }
    }
}
