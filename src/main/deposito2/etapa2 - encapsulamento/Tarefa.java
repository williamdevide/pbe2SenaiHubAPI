package com.example.projeto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Tarefa { // Renomeado para Tarefa (singular)
    private String id;
    private String descricao;
    private String status;
    private String dataAbertura;
    private String dataConclusao;
    private String dataExclusao;

    // Construtor
    public Tarefa(String id, String descricao, String status, String dataAbertura) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataConclusao = ""; // Inicializa vazio
        this.dataExclusao = ""; // Inicializa vazio
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus() {
        return status;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    // Método para converter a Tarefa em um Map (útil para retorno de API)
    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("id", this.id);
        map.put("descricao", this.descricao);
        map.put("status", this.status);
        map.put("dataAbertura", this.dataAbertura);
        map.put("dataConclusao", this.dataConclusao);
        map.put("dataExclusao", this.dataExclusao);
        return map;
    }

    // Lista estática para armazenar as tarefas em memória
    public static List<Tarefa> tarefas = new ArrayList<>();
    // Variável estática para controlar o próximo ID disponível
    public static int proximoId = 1;

    // Método para obter a data e hora atual (movido para cá para ser reutilizável)
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}