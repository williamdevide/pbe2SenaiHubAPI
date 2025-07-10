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
        return Contato.contatos.stream() // Usa a lista estática da classe Contato
                .filter(c -> status == null || c.getStatus().equalsIgnoreCase(status)) // Acessa o status usando o getter
                .map(Contato::toMap) // Converte cada objeto Contato para Map
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarContato(@PathVariable String id) {
        return Contato.contatos.stream() // Usa a lista estática da classe Contato
                .filter(c -> c.getId().equals(id)) // Acessa o ID usando o getter
                .findFirst()
                .map(Contato::toMap) // Converte o objeto Contato encontrado para Map
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    @PostMapping("/criar")
    public Map<String, String> criarContato(@RequestBody Map<String, String> novoContatoRequest) { // Renomeado para evitar conflito
        String id = String.valueOf(Contato.proximoId++); // Usa o proximoId da classe Contato
        String dataCadastro = Contato.getCurrentDateTime(); // Usa o método estático da classe Contato

        Contato contato = new Contato(
                id,
                novoContatoRequest.getOrDefault("nome", ""),
                novoContatoRequest.getOrDefault("email", ""),
                novoContatoRequest.getOrDefault("telefone", ""),
                "ativo",
                dataCadastro
        );

        Contato.contatos.add(contato); // Adiciona o objeto Contato à lista estática

        return Map.of(
                "id", id,
                "mensagem", "Contato criado com sucesso",
                "data", dataCadastro // Usa a data gerada
        );
    }

    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarContato(@PathVariable String id, @RequestBody Map<String, String> atualizacao) {
        return Contato.contatos.stream() // Usa a lista estática da classe Contato
                .filter(c -> c.getId().equals(id)) // Acessa o ID usando o getter
                .findFirst()
                .map(c -> {
                    if (atualizacao.containsKey("nome")) {
                        c.setNome(atualizacao.get("nome")); // Usa o setter
                    }
                    if (atualizacao.containsKey("email")) {
                        c.setEmail(atualizacao.get("email")); // Usa o setter
                    }
                    if (atualizacao.containsKey("telefone")) {
                        c.setTelefone(atualizacao.get("telefone")); // Usa o setter
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
        return Contato.contatos.stream() // Usa a lista estática da classe Contato
                .filter(c -> c.getId().equals(id)) // Acessa o ID usando o getter
                .findFirst()
                .map(c -> {
                    c.setStatus("inativo"); // Usa o setter
                    c.setDataInativacao(Contato.getCurrentDateTime()); // Usa o setter e o método estático
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
        // Remover da lista de Contato
        boolean removido = Contato.contatos.removeIf(c -> c.getId().equals(id)); // Acessa o ID usando o getter
        if (removido) {
            return Map.of("sucesso", "Contato excluído com sucesso.");
        } else {
            return Map.of("erro", "Contato não encontrado.");
        }
    }
}