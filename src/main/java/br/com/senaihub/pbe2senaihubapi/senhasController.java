package br.com.senaihub.pbe2senaihubapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller para os endpoints da API de Senhas.
 * Permite operações CRUD para senhas.
 * Mapeado para o caminho base "/api/senhas".
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/senhas")
public class senhasController {

    /**
     * Lista todas as senhas, com filtro opcional por status.
     *
     * @param status (Opcional) Filtra as senhas pelo status.
     * @return Uma lista de mapas, onde cada mapa representa uma senha.
     */
    @GetMapping("/listar")
    public List<Map<String, String>> listarSenhas(@RequestParam(required = false) String status) { //
        return Senha.senhas.stream()
                .filter(s -> status == null || s.getStatus().equalsIgnoreCase(status))
                .map(Senha::toMap)
                .collect(Collectors.toList());
    }

    /**
     * Busca uma senha específica pelo seu ID.
     *
     * @param id O ID da senha a ser buscada.
     * @return Um mapa com os dados da senha encontrada ou uma mensagem de erro.
     */
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarSenha(@PathVariable String id) { //
        return Senha.senhas.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(Senha::toMap)
                .orElse(Map.of("erro", "Senha não encontrada"));
    }

    /**
     * Cria uma nova senha.
     *
     * @param novaSenhaRequest Um mapa com os dados da nova senha ("descricao", "url", "senha").
     * @return Um mapa com o ID, mensagem de sucesso e data de criação.
     */
    @PostMapping("/criar")
    public Map<String, String> criarSenha(@RequestBody Map<String, String> novaSenhaRequest) { //
        String id = String.valueOf(Senha.proximoId++);
        String dataAbertura = ItemBase.getCurrentDateTime();
        Senha senha = new Senha(
                id,
                novaSenhaRequest.getOrDefault("descricao", ""),
                novaSenhaRequest.getOrDefault("url", ""),
                novaSenhaRequest.getOrDefault("senha", ""),
                "aberta",
                dataAbertura
        );
        Senha.senhas.add(senha);
        return Map.of(
                "id", id,
                "mensagem", "Senha criada com sucesso",
                "dataAbertura", dataAbertura
        );
    }

    /**
     * Atualiza os dados de uma senha existente.
     *
     * @param id          O ID da senha a ser atualizada.
     * @param atualizacao Um mapa contendo os novos dados para a senha.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarSenha(@PathVariable String id, @RequestBody Map<String, String> atualizacao) { //
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
                        s.setSenha(atualizacao.get("senha"));
                    }
                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Senha atualizada",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Senha não encontrada"));
    }

    /**
     * Exclui permanentemente uma senha do sistema.
     *
     * @param id O ID da senha a ser excluída.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirSenha(@PathVariable String id) { //
        boolean removido = Senha.senhas.removeIf(s -> s.getId().equals(id));
        if (removido) {
            return Map.of("sucesso", "Senha excluída com sucesso.");
        } else {
            return Map.of("erro", "Senha não encontrada.");
        }
    }
}