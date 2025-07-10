package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
// @RequestMapping("/api/alunos")
public class revisao2A {

    // Banco de dados em memória (simulado)
    private final List<Map<String, String>> alunos = List.of(
        Map.of("id", "1", "nome", "Ana Costa", "curso", "Spring Boot", "periodo", "manha", "status", "ativo"),
        Map.of("id", "2", "nome", "Carlos Santos", "curso", "Java", "periodo", "tarde", "status", "inativo"),
        Map.of("id", "3", "nome", "Beatriz Lima", "curso", "Spring Framework", "periodo", "noite", "status", "ativo")
    );

    // 1. Endpoint básico com @PathVariable (revisão teste2)
    @GetMapping("/saudacao/{nome}")
    public String saudarAluno(@PathVariable String nome) {
        return "Bem-vindo(a), " + nome + "! (ID: " + 
               alunos.stream()
                     .filter(a -> a.get("nome").equalsIgnoreCase(nome))
                     .findFirst()
                     .map(a -> a.get("id"))
                     .orElse("não encontrado") + ")";
    }

    // 2. Endpoint com @RequestParam e validação (revisão teste3-7)
    @GetMapping("/periodo")
    public String filtrarPorPeriodo(@RequestParam String turno) {
        return switch (turno.toLowerCase()) {
            case "manha" -> "Alunos do matutino: " + 
                           alunos.stream()
                                 .filter(a -> a.get("periodo").equalsIgnoreCase("manha"))
                                 .count();
            case "tarde" -> "Alunos do vespertino: " + 
                            alunos.stream()
                                  .filter(a -> a.get("periodo").equalsIgnoreCase("tarde"))
                                  .count();
            case "noite" -> "Alunos do noturno: " + 
                           alunos.stream()
                                 .filter(a -> a.get("periodo").equalsIgnoreCase("noite"))
                                 .count();
            default -> "Turno inválido. Use: manha, tarde ou noite";
        };
    }

    // 3. Endpoint que retorna lista completa (revisão teste10-11)
    @GetMapping
    public List<Map<String, String>> listarTodos(
        @RequestParam(required = false) String status) {
        
        if (status != null) {
            return alunos.stream()
                       .filter(a -> a.get("status").equalsIgnoreCase(status))
                       .toList();
        }
        return alunos;
    }

    // 4. Endpoint com busca por ID (revisão teste12-13)
    @GetMapping("/{id}")
    public Map<String, String> buscarPorId(@PathVariable String id) {
        return alunos.stream()
                   .filter(aluno -> aluno.get("id").equals(id))
                   .findFirst()
                   .orElse(Map.of("erro", "Aluno não encontrado"));
    }

    // 5. Endpoint com múltiplos parâmetros (revisão teste4-5 aprimorado)
    @GetMapping("/filtro")
    public List<Map<String, String>> filtrar(
        @RequestParam(required = false) String curso,
        @RequestParam(required = false) String periodo) {
        
        return alunos.stream()
                   .filter(a -> curso == null || a.get("curso").equalsIgnoreCase(curso))
                   .filter(a -> periodo == null || a.get("periodo").equalsIgnoreCase(periodo))
                   .toList();
    }
}