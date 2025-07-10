package br.com.senaihub.pbe2senaihubapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável pelos endpoints da API relacionados a Tarefas.
 * Mapeado para o caminho base "/api/tarefas".
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tarefas")
public class tarefasController {

    /**
     * Lista todas as tarefas existentes. Permite filtrar por status.
     *
     * @param status (Opcional) Filtra as tarefas pelo status informado (ex: "aberta", "concluida").
     * @return Uma lista de mapas, onde cada mapa representa uma tarefa.
     */
    @GetMapping("/listar")
    public List<Map<String, String>> listarTarefas(@RequestParam(required = false) String status) { // [cite: 2]
        return Tarefa.tarefas.stream()
                .filter(t -> status == null || t.getStatus().equalsIgnoreCase(status))
                .map(Tarefa::toMap)
                .collect(Collectors.toList());
    }

    /**
     * Busca uma tarefa específica pelo seu ID.
     *
     * @param id O ID da tarefa a ser buscada.
     * @return Um mapa com os dados da tarefa encontrada ou uma mensagem de erro.
     */
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarTarefa(@PathVariable String id) { // [cite: 2]
        return Tarefa.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(Tarefa::toMap)
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    /**
     * Cria uma nova tarefa no sistema com o status inicial "aberta".
     *
     * @param novaTarefaRequest Um mapa vindo do corpo da requisição com a descrição da nova tarefa.
     * @return Um mapa com o ID e mensagem de sucesso da nova tarefa.
     */
    @PostMapping("/criar")
    public Map<String, String> criarTarefa(@RequestBody Map<String, String> novaTarefaRequest) { // [cite: 2]
        String id = String.valueOf(Tarefa.proximoId++);
        String dataAbertura = ItemBase.getCurrentDateTime();
        Tarefa tarefa = new Tarefa(
                id,
                novaTarefaRequest.getOrDefault("descricao", ""),
                "aberta",
                dataAbertura
        );
        Tarefa.tarefas.add(tarefa);
        return Map.of("id", id, "mensagem", "Tarefa incluída com sucesso");
    }

    /**
     * Marca uma tarefa como concluída, alterando seu status e definindo a data de conclusão.
     *
     * @param id O ID da tarefa a ser concluída.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @PutMapping("/{id}/concluir")
    public Map<String, String> concluirTarefa(@PathVariable String id) { // [cite: 2]
        return Tarefa.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> {
                    t.setStatus("concluida");
                    t.setDataConclusao(ItemBase.getCurrentDateTime());
                    return Map.of("id", id, "mensagem", "Tarefa concluída");
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }

    /**
     * Realiza a exclusão lógica (soft delete) de uma tarefa.
     * O status é alterado para "excluida" e a data de exclusão é registrada.
     * A tarefa não é removida da lista.
     *
     * @param id O ID da tarefa a ser "excluída".
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirTarefa(@PathVariable String id) { // [cite: 2]
        return Tarefa.tarefas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> {
                    t.setStatus("excluida");
                    t.setDataExclusao(ItemBase.getCurrentDateTime());
                    return Map.of("id", id, "mensagem", "Tarefa excluída");
                })
                .orElse(Map.of("erro", "Tarefa não encontrada"));
    }
}