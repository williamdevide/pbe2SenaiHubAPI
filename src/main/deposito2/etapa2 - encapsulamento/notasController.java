package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*") // Permite requisições de qualquer origem, útil para desenvolvimento front-end
@RestController
@RequestMapping("/api/notas")
public class notasController {

    // listarNotas: GET /api/notas/listar
    @GetMapping("/listar")
    public List<Map<String, String>> listarNotas(@RequestParam(required = false) String status) {
        return Nota.notas.stream()
                .filter(n -> status == null || n.getStatus().equalsIgnoreCase(status))
                .map(Nota::toMap)
                .collect(Collectors.toList());
    }

    // buscarNota: GET /api/notas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarNota(@PathVariable String id) {
        return Nota.notas.stream()
                .filter(n -> n.getId().equals(id))
                .findFirst()
                .map(Nota::toMap)
                .orElse(Map.of("erro", "Nota não encontrada"));
    }

    // criarNota: POST /api/notas/criar
    @PostMapping("/criar")
    public Map<String, String> criarNota(@RequestBody Map<String, String> novaNotaRequest) {
        String id = String.valueOf(Nota.proximoId++);
        String dataAbertura = Nota.getCurrentDateTime();

        // Conteúdo limitado a 5000 caracteres (ou conforme sua necessidade)
        String conteudo = novaNotaRequest.getOrDefault("conteudo", "");
        if (conteudo.length() > 5000) {
            conteudo = conteudo.substring(0, 5000);
        }

        Nota nota = new Nota(
                id,
                novaNotaRequest.getOrDefault("descricao", ""),
                conteudo,
                "aberta", // Status inicial
                dataAbertura
        );

        Nota.notas.add(nota);

        return Map.of(
                "id", id,
                "mensagem", "Nota criada com sucesso",
                "dataAbertura", dataAbertura
        );
    }

    // atualizarNota: PUT /api/notas/{id}/atualizar
    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarNota(@PathVariable String id, @RequestBody Map<String, String> atualizacao) {
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

    // excluirNota: DELETE /api/notas/{id}/excluir
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirNota(@PathVariable String id) {
        // Exclusão física: remove a nota da lista
        boolean removido = Nota.notas.removeIf(n -> n.getId().equals(id));
        if (removido) {
            return Map.of("sucesso", "Nota excluída com sucesso.");
        } else {
            return Map.of("erro", "Nota não encontrada.");
        }
    }
}