package com.example.projeto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Senha {
    private String id;
    private String descricao;
    private String url;
    private String senha; // O campo da senha em si
    private String status;
    private String dataAbertura;

    // Construtor
    public Senha(String id, String descricao, String url, String senha, String status, String dataAbertura) {
        this.id = id;
        this.descricao = descricao;
        this.url = url;
        this.senha = senha;
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

    public String getUrl() {
        return url;
    }

    public String getSenha() {
        return senha;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para converter a Senha em um Map (útil para retorno de API)
    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("id", this.id);
        map.put("descricao", this.descricao);
        map.put("url", this.url);
        map.put("senha", this.senha); // Nunca retorne sem encriptar
        map.put("status", this.status);
        map.put("dataAbertura", this.dataAbertura);
        return map;
    }

    // Lista estática para armazenar as senhas em memória
    public static List<Senha> senhas = new ArrayList<>();
    // Variável estática para controlar o próximo ID disponível
    public static int proximoId = 1;

    // Método para obter a data e hora atual
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}