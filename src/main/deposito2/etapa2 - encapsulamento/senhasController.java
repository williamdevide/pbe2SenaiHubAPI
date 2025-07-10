package com.example.projeto1;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*") // Permite requisições de qualquer origem, útil para desenvolvimento front-end
@RestController
@RequestMapping("/api/senhas")
public class senhasController {

    // listarSenhas: GET /api/senhas/listar
    @GetMapping("/listar")
    public List<Map<String, String>> listarSenhas(@RequestParam(required = false) String status) {
        return Senha.senhas.stream()
                .filter(s -> status == null || s.getStatus().equalsIgnoreCase(status))
                .map(Senha::toMap)
                .collect(Collectors.toList());
    }

    // buscarSenha: GET /api/senhas/buscar/{id}
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarSenha(@PathVariable String id) {
        return Senha.senhas.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(Senha::toMap)
                .orElse(Map.of("erro", "Senha não encontrada"));
    }

    // criarSenha: POST /api/senhas/criar
    @PostMapping("/criar")
    public Map<String, String> criarSenha(@RequestBody Map<String, String> novaSenhaRequest) {
        String id = String.valueOf(Senha.proximoId++);
        String dataAbertura = Senha.getCurrentDateTime();

        Senha senha = new Senha(
                id,
                novaSenhaRequest.getOrDefault("descricao", ""),
                novaSenhaRequest.getOrDefault("url", ""),
                novaSenhaRequest.getOrDefault("senha", ""), // A senha em si
                "aberta", // Status inicial
                dataAbertura
        );

        Senha.senhas.add(senha);

        return Map.of(
                "id", id,
                "mensagem", "Senha criada com sucesso",
                "dataAbertura", dataAbertura
        );
    }

    // atualizarSenha: PUT /api/senhas/{id}/atualizar
    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarSenha(@PathVariable String id, @RequestBody Map<String, String> atualizacao) {
        return Senha.senhas.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(s -> {
                    if (atualizacao.containsKey("descricao")) {
                        s.setDescricao(atualizacao.get("descricao"));
                    }
                    if (atualizacao.containsKey("url")) {
                        s.setUrl(atualizacao.get("url"));
                    }
                    if (atualizacao.containsKey("senha")) {
                        s.setSenha(atualizacao.get("senha")); // Atualiza a senha
                    }
                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Senha atualizada",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Senha não encontrada"));
    }

    // excluirSenha: DELETE /api/senhas/{id}/excluir
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirSenha(@PathVariable String id) {
        // Exclusão física: remove a senha da lista
        boolean removido = Senha.senhas.removeIf(s -> s.getId().equals(id));
        if (removido) {
            return Map.of("sucesso", "Senha excluída com sucesso.");
        } else {
            return Map.of("erro", "Senha não encontrada.");
        }
    }
}