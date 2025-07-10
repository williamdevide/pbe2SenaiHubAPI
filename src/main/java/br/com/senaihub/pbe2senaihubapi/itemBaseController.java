package br.com.senaihub.pbe2senaihubapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller que expõe um endpoint especial para listar todos os itens da aplicação.
 * Demonstra o uso de Polimorfismo.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/itens")
public class itemBaseController {

    /**
     * Lista todos os itens de todos os tipos (Contatos, Tarefas, Notas, Senhas)
     * em uma única resposta.
     * <p>
     * Este método é um ótimo exemplo de polimorfismo. Ele trata todos os objetos
     * como 'ItemBase' e invoca o método 'toMap()' de cada um, que por sua vez
     * executa a implementação específica da subclasse correspondente.
     *
     * @return Uma lista de mapas, onde cada mapa representa um item de qualquer tipo.
     */
    @GetMapping("/listar")
    public List<Map<String, String>> listarTodosOsItens() {
        List<ItemBase> todosOsItens = new ArrayList<>();
        todosOsItens.addAll(Contato.contatos);
        todosOsItens.addAll(Tarefa.tarefas); // Esta linha agora está ativa.
        todosOsItens.addAll(Nota.notas);
        todosOsItens.addAll(Senha.senhas);

        return todosOsItens.stream()
                .map(ItemBase::toMap)
                .collect(Collectors.toList());
    }
}