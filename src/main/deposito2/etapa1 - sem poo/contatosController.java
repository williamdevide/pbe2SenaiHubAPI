package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contatos")
public class contatosController {

    private String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @GetMapping("/listar")
    public List<Map<String, String>> listarContatos(@RequestParam(required = false) String status) {
        return contatosModel.contatos.stream()
                .filter(c -> status == null || c.get("status").equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarContato(@PathVariable String id) {
        return contatosModel.contatos.stream()
                .filter(c -> c.get("id").equals(id))
                .findFirst()
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    @PostMapping("/criar")
    public Map<String, String> criarContato(@RequestBody Map<String, String> novoContato) {
        String id = String.valueOf(contatosModel.proximoId++);
        Map<String, String> contato = new ConcurrentHashMap<>();

        contato.put("id", id);
        contato.put("nome", novoContato.getOrDefault("nome", ""));
        contato.put("email", novoContato.getOrDefault("email", ""));
        contato.put("telefone", novoContato.getOrDefault("telefone", ""));
        contato.put("status", "ativo");
        contato.put("dataCadastro", getCurrentDateTime());
        contato.put("dataInativacao", "");
        contato.put("dataExclusao", "");

        contatosModel.contatos.add(contato);

        return Map.of(
                "id", id,
                "mensagem", "Contato criado com sucesso",
                "data", getCurrentDateTime()
        );
    }

    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarContato(@PathVariable String id, @RequestBody Map<String, String> atualizacao) {
        return contatosModel.contatos.stream()
                .filter(c -> c.get("id").equals(id))
                .findFirst()
                .map(c -> {
                    if (atualizacao.containsKey("nome")) {
                        c.put("nome", atualizacao.get("nome"));
                    }
                    if (atualizacao.containsKey("email")) {
                        c.put("email", atualizacao.get("email"));
                    }
                    if (atualizacao.containsKey("telefone")) {
                        c.put("telefone", atualizacao.get("telefone"));
                    }
                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Contato atualizado",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    @PutMapping("/{id}/inativar")
    public Map<String, String> inativarContato(@PathVariable String id) {
        return contatosModel.contatos.stream()
                .filter(c -> c.get("id").equals(id))
                .findFirst()
                .map(c -> {
                    c.put("status", "inativo");
                    c.put("dataInativacao", getCurrentDateTime());

                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Contato inativado",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirContato(@PathVariable String id) {
        boolean removido = contatosModel.contatos.removeIf(c -> c.get("id").equals(id));
        if (removido) {
            return Map.of("sucesso", "Contato excluído com sucesso.");
        } else {
            return Map.of("erro", "Contato não encontrado.");
        }
        
    }
}
