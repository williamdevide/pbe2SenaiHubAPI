// tarefasController.java
package com.example.projeto1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tarefas")
public class tarefasController {

    @GetMapping("/listar")
    public List<Map<String, String>> listarTarefas(@RequestParam(required = false) String status) {
        return Tarefa.tarefas.stream()
                .filter(t -> status == null || t.getStatus().equalsIgnoreCase(status))
                .map(Tarefa::toMap)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarTarefa(@PathVariable String id) {
        return Tarefa.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(Tarefa::toMap)
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    @PostMapping("/criar")
    public Map<String, String> criarTarefa(@RequestBody Map<String, String> novaTarefaRequest) {
        String id = String.valueOf(Tarefa.proximoId++);
        String dataAbertura = ItemBase.getCurrentDateTime(); // Usa o método da classe base

        // Instancia Tarefa usando o construtor adaptado para herança
        Tarefa tarefa = new Tarefa(
                id,
                novaTarefaRequest.getOrDefault("descricao", ""),
                "aberta",
                dataAbertura
        );

        Tarefa.tarefas.add(tarefa);

        return Map.of("id", id, "mensagem", "Tarefa incluída com sucesso");
    }

    @PutMapping("/{id}/concluir")
    public Map<String, String> concluirTarefa(@PathVariable String id) {
        return Tarefa.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> {
                    t.setStatus("concluida");
                    t.setDataConclusao(ItemBase.getCurrentDateTime()); // Usa o método da classe base
                    return Map.of("id", id, "mensagem", "Tarefa concluída");
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirTarefa(@PathVariable String id) {
        return Tarefa.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> {
                    t.setStatus("excluida");
                    t.setDataExclusao(ItemBase.getCurrentDateTime()); // Usa o método da classe base
                    return Map.of("id", id, "mensagem", "Tarefa excluída");
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }
}
