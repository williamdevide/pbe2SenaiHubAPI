package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste6 {
    
    @GetMapping("/periodo1")
    public String periodo1(
        @RequestParam String hora) {
            try {
                int horaInt = Integer.parseInt(hora);
                if (horaInt >= 5 && horaInt <= 11) {
                    return "Bom dia";
                } else if (horaInt >= 12 && horaInt <= 18) {
                    return "Boa tarde";
                } else {
                    return "Boa noite";
                }
            } catch (NumberFormatException e) {
                return "Formato de hora inválido. Use um número entre 00 e 23.";
            }
        }
}

// http://localhost:8080/periodo1?hora=10