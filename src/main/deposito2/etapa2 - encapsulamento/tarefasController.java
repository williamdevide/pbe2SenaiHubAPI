package com.example.projeto1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tarefas")
public class tarefasController {

    // listarTarefas: GET /api/tarefas/listar
    @GetMapping("/listar")
    public List<Map<String, String>> listarTarefas() {
        return Tarefa.tarefas.stream() // Usa a lista estática da classe Tarefa
                .map(Tarefa::toMap) // Converte cada objeto Tarefa para Map
                .collect(Collectors.toList());
    }

    // buscarTarefa: GET /api/tarefas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarTarefa(@PathVariable String id) {
        return Tarefa.tarefas.stream() // Usa a lista estática da classe Tarefa
                .filter(t -> t.getId().equals(id)) // Acessa o ID usando o getter
                .findFirst()
                .map(Tarefa::toMap) // Converte o objeto Tarefa encontrado para Map
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    // criarTarefa: POST /api/tarefas/criar
    @PostMapping("/criar")
    public Map<String, String> criarTarefa(@RequestBody Map<String, String> novaTarefaRequest) { // Renomeado para evitar conflito
        String id = String.valueOf(Tarefa.proximoId++); // Usa o proximoId da classe Tarefa
        String dataAbertura = Tarefa.getCurrentDateTime(); // Usa o método estático da classe Tarefa

        Tarefa tarefa = new Tarefa(
                id,
                novaTarefaRequest.getOrDefault("descricao", ""),
                "aberta",
                dataAbertura
        );

        Tarefa.tarefas.add(tarefa); // Adiciona o objeto Tarefa à lista estática

        return Map.of("id", id, "mensagem", "Tarefa incluída com sucesso");
    }

    // concluirTarefa: PUT /api/tarefas/{id}/concluir
    @PutMapping("/{id}/concluir")
    public Map<String, String> concluirTarefa(@PathVariable String id) {
        return Tarefa.tarefas.stream() // Usa a lista estática da classe Tarefa
                .filter(t -> t.getId().equals(id)) // Acessa o ID usando o getter
                .findFirst()
                .map(t -> {
                    t.setStatus("concluida"); // Usa o setter
                    t.setDataConclusao(Tarefa.getCurrentDateTime()); // Usa o setter e o método estático
                    return Map.of("id", id, "mensagem", "Tarefa concluída");
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    // excluirTarefa: DELETE /api/tarefas/{id}/excluir
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirTarefa(@PathVariable String id) {
        return Tarefa.tarefas.stream() // Usa a lista estática da classe Tarefa
                .filter(t -> t.getId().equals(id)) // Acessa o ID usando o getter
                .findFirst()
                .map(t -> {
                    t.setStatus("excluida"); // Usa o setter
                    t.setDataExclusao(Tarefa.getCurrentDateTime()); // Usa o setter e o método estático
                    return Map.of("id", id, "mensagem", "Tarefa excluída");
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }
}