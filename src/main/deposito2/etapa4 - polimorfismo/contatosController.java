// contatosController.java
package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contatos")
public class contatosController {

    @GetMapping("/listar")
    public List<Map<String, String>> listarContatos(@RequestParam(required = false) String status) {
        return Contato.contatos.stream()
                .filter(c -> status == null || c.getStatus().equalsIgnoreCase(status))
                .map(Contato::toMap)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarContato(@PathVariable String id) {
        return Contato.contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(Contato::toMap)
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    @PostMapping("/criar")
    public Map<String, String> criarContato(@RequestBody Map<String, String> novoContatoRequest) {
        String id = String.valueOf(Contato.proximoId++);
        String dataCadastro = ItemBase.getCurrentDateTime(); // Usa o método da classe base

        // Instancia Contato usando o construtor adaptado para herança
        Contato contato = new Contato(
                id,
                novoContatoRequest.getOrDefault("nome", ""),
                novoContatoRequest.getOrDefault("email", ""),
                novoContatoRequest.getOrDefault("telefone", ""),
                "ativo",
                dataCadastro
        );

        Contato.contatos.add(contato);

        return Map.of(
                "id", id,
                "mensagem", "Contato criado com sucesso",
                "data", dataCadastro
        );
    }

    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarContato(@PathVariable String id, @RequestBody Map<String, String> atualizacao) {
        return Contato.contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    if (atualizacao.containsKey("nome")) {
                        c.setNome(atualizacao.get("nome")); // Usa o setter
                    }
                    if (atualizacao.containsKey("email")) {
                        c.setEmail(atualizacao.get("email"));
                    }
                    if (atualizacao.containsKey("telefone")) {
                        c.setTelefone(atualizacao.get("telefone"));
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
        return Contato.contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    c.setStatus("inativo");
                    c.setDataInativacao(ItemBase.getCurrentDateTime()); // Usa o método da classe base
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
        boolean removido = Contato.contatos.removeIf(c -> c.getId().equals(id));
        if (removido) {
            return Map.of("sucesso", "Contato excluído com sucesso.");
        } else {
            return Map.of("erro", "Contato não encontrado.");
        }
    }
}
