package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class tarefasController {

    private String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @GetMapping
    public List<Map<String, String>> listarTarefas(@RequestParam(required = false) String status) {
        return tarefasModel.tarefas.stream()
                .filter(t -> status == null || t.get("status").equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Map<String, String> buscarTarefa(@PathVariable String id) {
        return tarefasModel.tarefas.stream()
                .filter(t -> t.get("id").equals(id))
                .findFirst()
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    @PostMapping
    public Map<String, String> criarTarefa(@RequestBody Map<String, String> novaTarefa) {
        String id = String.valueOf(tarefasModel.proximoId++);
        Map<String, String> tarefa = new ConcurrentHashMap<>();

        tarefa.put("id", id);
        tarefa.put("descricao", novaTarefa.getOrDefault("descricao", ""));
        tarefa.put("status", "aberta");
        tarefa.put("dataAbertura", getCurrentDateTime());
        tarefa.put("dataConclusao", "");
        tarefa.put("dataExclusao", "");

        tarefasModel.tarefas.add(tarefa);

        return Map.of(
                "id", id,
                "mensagem", "Tarefa criada com sucesso",
                "data", getCurrentDateTime()
        );
    }

    @PutMapping("/{id}")
    public Map<String, String> atualizarTarefa(@PathVariable String id, @RequestBody Map<String, String> atualizacao) {
        return tarefasModel.tarefas.stream()
                .filter(t -> t.get("id").equals(id))
                .findFirst()
                .map(t -> {
                    if (atualizacao.containsKey("descricao")) {
                        t.put("descricao", atualizacao.get("descricao"));
                    }
                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Tarefa atualizada",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    @PutMapping("/{id}/concluir")
    public Map<String, String> concluirTarefa(@PathVariable String id, @RequestBody(required = false) Map<String, String> dados) {
        return tarefasModel.tarefas.stream()
                .filter(t -> t.get("id").equals(id))
                .findFirst()
                .map(t -> {
                    t.put("status", "concluida");
                    t.put("dataConclusao", getCurrentDateTime());

                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Tarefa marcada como concluída",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    @DeleteMapping("/{id}")
    public Map<String, String> excluirTarefa(@PathVariable String id, @RequestBody(required = false) Map<String, String> dados) {
        return tarefasModel.tarefas.stream()
                .filter(t -> t.get("id").equals(id))
                .findFirst()
                .map(t -> {
                    t.put("status", "excluida");
                    t.put("dataExclusao", getCurrentDateTime());

                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Tarefa marcada como excluída",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

}
