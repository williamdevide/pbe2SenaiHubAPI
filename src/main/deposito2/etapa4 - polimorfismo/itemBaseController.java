package com.example.projeto1;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/itens")
public class itemBaseController {

    @GetMapping("/listar")
    public List<Map<String, String>> listarTodosOsItens() {
        List<ItemBase> todosOsItens = new ArrayList<>();

        todosOsItens.addAll(Contato.contatos);
        todosOsItens.addAll(Tarefa.tarefas);
        todosOsItens.addAll(Nota.notas);
        todosOsItens.addAll(Senha.senhas);

        return todosOsItens.stream()
                .map(ItemBase::toMap) // A magia do polimorfismo acontece aqui!
                .collect(Collectors.toList());
    }
}
