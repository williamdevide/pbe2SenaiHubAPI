package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

@RestController
public class desafio2 {

    @GetMapping("/desafio2")
    public String classificarIdade(
        @RequestParam String nome,
        @RequestParam(required = false) String idade) {
    
        if (nome == null) {
            return "Olá, você não informou seu nome";
        } else {
            try {
                int idadeInt = Integer.parseInt(idade);
                if (idadeInt >= 0 && idadeInt <= 12) {
                    return nome + " você é Criança";
                } else if (idadeInt >= 13 && idadeInt <= 17) {
                    return nome + " você é Adolescente";
                } else if (idadeInt >= 18 && idadeInt <= 64) {
                    return nome + " você é Adulto";
                } else if (idadeInt >= 65 && idadeInt <= 100) {
                    return nome + " você é Idoso";
                } else {
                    return nome + " Idade inválida.";
                }
            } catch (NumberFormatException e) {
                return "Formato de idade inválido. Use um número válido para a idade.";
            }
        }
    }
}