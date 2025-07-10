// ItemBase.java
package com.example.projeto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemBase {
    protected String id;
    protected String descricao;
    protected String dataCriacao;

    public ItemBase(String id, String descricao, String dataCriacao) {
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    // --- Getters para os atributos comuns ---
    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    // --- Setters para atributos que podem ser modificados ---
    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("id", this.id);
        map.put("descricao", this.descricao);
        map.put("dataCriacao", this.dataCriacao);
        return map;
    }
}
