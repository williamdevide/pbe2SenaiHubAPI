package br.com.senaihub.pbe2senaihubapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller responsável pelos endpoints da API relacionados a Contatos.
 * Mapeado para o caminho base "/api/contatos".
 */
@RestController
@RequestMapping("/api/contatos")
public class contatosController {

    /**
     * Lista todos os contatos existentes. Permite filtrar por status.
     *
     * @param status (Opcional) Filtra os contatos pelo status informado (ex: "ativo", "inativo").
     * @return Uma lista de mapas, onde cada mapa representa um contato.
     */
    @GetMapping("/listar")
    public List<Map<String, String>> listarContatos(@RequestParam(required = false) String status) { //
        return Contato.contatos.stream()
                .filter(c -> status == null || c.getStatus().equalsIgnoreCase(status))
                .map(Contato::toMap)
                .collect(Collectors.toList());
    }

    /**
     * Busca um contato específico pelo seu ID.
     *
     * @param id O ID do contato a ser buscado.
     * @return Um mapa com os dados do contato encontrado ou uma mensagem de erro.
     */
    @GetMapping("/buscar/{id}")
    public Map<String, String> buscarContato(@PathVariable String id) { //
        return Contato.contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(Contato::toMap)
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    /**
     * Cria um novo contato no sistema.
     *
     * @param novoContatoRequest Um mapa vindo do corpo da requisição com os dados do novo contato.
     * @return Um mapa com o ID, mensagem de sucesso e data de criação do novo contato.
     */
    @PostMapping("/criar")
    public Map<String, String> criarContato(@RequestBody Map<String, String> novoContatoRequest) { //
        String id = String.valueOf(Contato.proximoId++);
        String dataCadastro = ItemBase.getCurrentDateTime();
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

    /**
     * Atualiza os dados de um contato existente.
     * <p>
     * Apenas os campos presentes no corpo da requisição serão atualizados.
     *
     * @param id          O ID do contato a ser atualizado.
     * @param atualizacao Um mapa contendo os novos dados para o contato (ex: "nome", "email").
     * @return Um mapa com uma mensagem de sucesso ou uma mensagem de erro se o contato não for encontrado.
     */
    @PutMapping("/{id}/atualizar")
    public Map<String, String> atualizarContato(@PathVariable String id, @RequestBody Map<String, String> atualizacao) { //
        return Contato.contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    if (atualizacao.containsKey("nome")) {
                        c.setNome(atualizacao.get("nome"));
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

    /**
     * Inativa um contato, alterando seu status para "inativo".
     *
     * @param id O ID do contato a ser inativado.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @PutMapping("/{id}/inativar")
    public Map<String, String> inativarContato(@PathVariable String id) { //
        return Contato.contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    c.setStatus("inativo");
                    c.setDataInativacao(ItemBase.getCurrentDateTime());
                    return Map.of(
                            "status", "sucesso",
                            "mensagem", "Contato inativado",
                            "id", id
                    );
                })
                .orElse(Map.of("erro", "Contato não encontrado"));
    }

    /**
     * Exclui permanentemente um contato do sistema.
     *
     * @param id O ID do contato a ser excluído.
     * @return Um mapa com uma mensagem de sucesso ou erro.
     */
    @DeleteMapping("/{id}/excluir")
    public Map<String, String> excluirContato(@PathVariable String id) { //
        boolean removido = Contato.contatos.removeIf(c -> c.getId().equals(id));
        if (removido) {
            return Map.of("sucesso", "Contato excluído com sucesso.");
        } else {
            return Map.of("erro", "Contato não encontrado.");
        }
    }
}