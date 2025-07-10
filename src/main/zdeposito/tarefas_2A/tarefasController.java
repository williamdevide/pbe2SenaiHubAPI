package com.example.projeto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tarefas")
public class tarefasController {
    // listarTarefas: GET /api/tarefas
    @GetMapping("/listar")
    public List<Map<String, String>> listarTarefas() {
        return tarefasModel.tarefas;
    }
      
    // buscarTarefa: GET /api/tarefas/{id}
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarTarefa(@PathVariable String id) {
        return tarefasModel.tarefas.stream()
            .filter(t -> t.get("id").equals(id))
            .findFirst()
            .orElse(Map.of("erro","Tarefa não encontrada"));
    }
    
    // criarTarefa: POST /api/tarefas
    @PostMapping("/criar")
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
        
    // atualizarTarefa: PUT /api/tarefas/{id}
    // concluirTarefa: PUT /api/tarefas/{id}/concluir
    @PutMapping("{id}/concluir")
    public Map<String, String> concluirTarefa(
        @PathVariable String id) {
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
        .orElse(Map.of("erro","Tarefa não encontrada"));
    }

    // excluirTarefa: DELETE /api/tarefas/{id}
    @DeleteMapping("{id}/excluir")
    public Map<String, String> excluirTarefa(
        @PathVariable String id) {
        return tarefasModel.tarefas.stream()
        .filter(t -> t.get("id").equals(id))
        .findFirst()
        .map(t -> {
            t.put("status", "excluida");
            t.put("dataExclusao", getCurrentDateTime());

            return Map.of(
                "id", id,
                "mensagem", "Tarefa excluída com sucesso"
            );

        })
        .orElse(Map.of("erro","Tarefa não encontrada"));
    }
    
    // Método para obter a data e hora atual
    private String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
