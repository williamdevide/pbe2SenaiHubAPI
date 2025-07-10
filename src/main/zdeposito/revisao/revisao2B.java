package com.example.projeto1;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController

public class revisao2B {

    // Banco de dados em memória (simulado)
    private List<Map<String, String>> alunos = List.of(
        Map.of("id","1","nome","Thariane","idade","18"),
        Map.of("id","2","nome","Sarah","idade","18"),
        Map.of("id","3","nome","Pazinato","idade","18"),
        Map.of("id","4","nome","Isadora","idade","18")
    );
    
    
    

    // 1. Endpoint básico com @PathVariable (revisão teste2)
    // String Bem vindo William (ID: 4)
    @GetMapping("/saudacao/{apelido}")
    public String revisao1(@PathVariable String apelido) {
        return "Bom dia" + apelido + "ID:" + alunos.stream()
        .filter(a -> a.get("nome").equalsIgnoreCase(apelido))
        .findFirst()
        .map(a -> a.get("id"))
        .orElse("Não encontrado")
        ;
    }

    @GetMapping("/benvindo")
    public String revisao2(
        @RequestParam String apelido,
        @RequestParam String idade
        ) {
        return "Bom dia" + apelido + "ID:" + alunos.stream()
        .filter(a -> a.get("nome").equalsIgnoreCase(apelido))
        .findFirst()
        .map(a -> a.get("id"))
        .orElse("Não encontrado")
        ;
    }






    // 2. Endpoint com @RequestParam e validação (revisão teste3-7)
    // Todos (List) de um determinado período
    @GetMapping("/periodo")
    public String revisaox2() {
        return "";
    }

    // 3. Endpoint que retorna lista completa (revisão teste10-11)
    // Todos (List)
    @GetMapping
    public String revisao3() {
         return "";
    }

    // 4. Endpoint com busca por ID (revisão teste12-13)
    // Único (Map)
    @GetMapping("/{id}")
    public String revisao4() {
        return "";
   }

    // 5. Endpoint com múltiplos parâmetros (revisão teste4-5 aprimorado)
    // Todos (List) por parametro
    @GetMapping("/filtro")
    public String revisao5() {
        return "";
   }
}