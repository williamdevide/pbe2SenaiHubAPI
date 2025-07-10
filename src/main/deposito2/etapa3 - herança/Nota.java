// Nota.java
package com.example.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Nota extends ItemBase {
    private String conteudo; // Pode guardar uma grande quantidade de texto
    private String status;   // Ex: "aberta", "excluida"

    public static List<Nota> notas = new ArrayList<>();
    public static int proximoId = 1;

    public Nota(String id, String descricao, String conteudo, String status, String dataAbertura) {
        super(id, descricao, dataAbertura);
        this.conteudo = conteudo;
        this.status = status;
    }

    // --- Getters e Setters para atributos específicos de Nota ---
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        // Atributos herdados de ItemBase
        map.put("id", this.getId());
        map.put("descricao", this.getDescricao());
        map.put("dataAbertura", this.getDataCriacao());

        // Atributos específicos de Nota
        map.put("conteudo", this.conteudo);
        map.put("status", this.status);
        return map;
    }
}
