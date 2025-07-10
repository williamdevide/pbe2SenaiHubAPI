package com.example.projeto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Nota {
    private String id;
    private String descricao;
    private String conteudo;
    private String status;
    private String dataAbertura;

    // Construtor
    public Nota(String id, String descricao, String conteudo, String status, String dataAbertura) {
        this.id = id;
        this.descricao = descricao;
        this.conteudo = conteudo;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getStatus() {
        return status;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para converter a Nota em um Map (útil para retorno de API)
    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("id", this.id);
        map.put("descricao", this.descricao);
        map.put("conteudo", this.conteudo);
        map.put("status", this.status);
        map.put("dataAbertura", this.dataAbertura);
        return map;
    }

    // Lista estática para armazenar as notas em memória
    public static List<Nota> notas = new ArrayList<>();
    // Variável estática para controlar o próximo ID disponível
    public static int proximoId = 1;

    // Método para obter a data e hora atual
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}