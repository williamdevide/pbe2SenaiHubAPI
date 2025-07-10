package com.example.projeto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Contato { // Renomeado para Contato (singular)
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private String dataCadastro;
    private String dataInativacao;
    private String dataExclusao;

    // Construtor
    public Contato(String id, String nome, String email, String telefone, String status, String dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.dataCadastro = dataCadastro;
        this.dataInativacao = ""; // Inicializa vazio
        this.dataExclusao = ""; // Inicializa vazio
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getStatus() {
        return status;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public String getDataInativacao() {
        return dataInativacao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataInativacao(String dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    // Método para converter o Contato em um Map (útil para retorno de API)
    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("id", this.id);
        map.put("nome", this.nome);
        map.put("email", this.email);
        map.put("telefone", this.telefone);
        map.put("status", this.status);
        map.put("dataCadastro", this.dataCadastro);
        map.put("dataInativacao", this.dataInativacao);
        map.put("dataExclusao", this.dataExclusao);
        return map;
    }

    // Lista estática para armazenar os contatos em memória
    public static List<Contato> contatos = new ArrayList<>();
    // Variável estática para controlar o próximo ID disponível
    public static int proximoId = 1;

    // Método para obter a data e hora atual
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}