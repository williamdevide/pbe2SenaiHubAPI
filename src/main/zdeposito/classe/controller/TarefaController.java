package com.example.projeto1.controller; 

import com.example.projeto1.model.Tarefa;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList<>();
    private AtomicLong contadorId = new AtomicLong(1);

    @GetMapping
    public List<Tarefa> listar() {
        return tarefas;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa novaTarefa) {
        Tarefa tarefa = new Tarefa(contadorId.getAndIncrement(), novaTarefa.getDescricao());
        tarefas.add(tarefa);
        return tarefa;
    }

    @PutMapping("/{id}")
    public Tarefa concluir(@PathVariable Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                tarefa.setConcluida(true);
                return tarefa;
            }
        }
        return null;
    }

}