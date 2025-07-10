package br.com.senaihub.pbe2senaihubapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller para os endpoints da API de Notas.
 * Permite operações CRUD para notas.
 * Mapeado para o caminho base "/api/notas".
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notas")
public class notasController {

    /**
     * Lista todas as notas, com filtro opcional por status.
     *
     * @param status (Opcional) Filtra as notas pelo status (ex: "aberta").
     * @return Uma lista de mapas, onde cada mapa representa uma nota.
     */
    @GetMapping("/listar")
    public List<Map<String, String>> listarNotas(@RequestParam(required = false) String status) { //
        return Nota.notas.stream()
                .filter(n -> status == null || n.getStatus().equalsIgnoreCase(status))
                .map(Nota::toMap)
                .collect(Collectors.toList());
    }

    /**
     * Busca uma nota específica pelo seu ID.
     *
     * @param id O ID da nota a ser buscada.
     * @return Um mapa com os dados da nota encontrada ou uma mensagem de erro.
     */
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarNota(@PathVariable String id) { //
        return Nota.notas.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .map(Nota::toMap)
                .orElse(Map.of("erro", "Nota não encontrada"));
    }

    /**
     * Cria uma nova nota. Limita o conteúdo a 5000 caracteres.
     *
     * @param novaNotaRequest Um mapa com os dados da nova nota ("descricao", "conteudo").
     * @return Um mapa com o ID, mensagem de sucesso e data de criação da nota.
     */
    @PostMapping("/criar")
    public Map<String, String> criarNota(@RequestBody Map<String, String> novaNotaRequest) { //
        String id = String.valueOf(Nota.proximoId++);
        String dataAbertura = ItemBase.getCurrentDateTime();
        String conteudo = novaNotaRequest.getOrDefault("conteudo", "");
        if (conteudo.length() > 5000) {
            conteudo = conteudo.substring(0, 5000);
        }
        Nota nota = new Nota(
                id,
                novaNotaRequest.getOrDefault("descricao", ""),
                conteudo,
                "aberta",
                dataAbertura
        );
        Nota.notas.add(nota);
        return Map.of(
                "id", id,
                "mensagem", "Nota criada com sucesso",
                "dataAbertura", dataAbertura
        );
    }

    /**
     * Atualiza os dados de uma nota existente.
     *
     * @param id          O ID da nota a ser atualizada.
     * @param atualizacao Um mapa contendo os novos dados para a nota.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarNota(@PathVariable String id, @RequestBody Map<String, String> atualizacao) { //
        return Nota.notas.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .map(n -> {
                    if (atualizacao.containsKey("descricao")) {
                        n.setDescricao(atualizacao.get("descricao"));
                    }
                    if (atualizacao.containsKey("conteudo")) {
                        String novoConteudo = atualizacao.get("conteudo");
                        if (novoConteudo != null && novoConteudo.length() > 5000) {
                            novoConteudo = novoConteudo.substring(0, 5000);
                        }
                        n.setConteudo(novoConteudo);
                    }
                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Nota atualizada",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Nota não encontrada"));
    }

    /**
     * Exclui permanentemente uma nota do sistema.
     *
     * @param id O ID da nota a ser excluída.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirNota(@PathVariable String id) { //
        boolean removido = Nota.notas.removeIf(n -> n.getId().equals(id));
        if (removido) {
            return Map.of("sucesso", "Nota excluída com sucesso.");
        } else {
            return Map.of("erro", "Nota não encontrada.");
        }
    }
}