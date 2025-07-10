package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class teste7 {
    
    @GetMapping("/periodo2")
    public String periodo2(
        @RequestParam String hora) {
            try {
                int horaInt = Integer.parseInt(hora);
                
                return switch (horaInt) {
                    case 5, 6, 7, 8, 9, 10, 11 -> "Bom dia";
                    case 12, 13, 14, 15, 16, 17, 18 -> "Boa tarde";
                    default -> "Boa noite";
                };
            } catch (NumberFormatException e) {
                return "Formato de hora inválido. Use um número entre 00 e 23.";
            }
        }
}

// http://localhost:8080/periodo2?hora=10