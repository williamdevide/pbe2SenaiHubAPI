package com.example.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Contato extends ItemBase {
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private String dataInativacao;
    private String dataExclusao;

    public static List<Contato> contatos = new ArrayList<>();
    public static int proximoId = 1;

    public Contato(String id, String nome, String email, String telefone, String status, String dataCadastro) {
        super(id, nome, dataCadastro);
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.dataInativacao = "";
        this.dataExclusao = "";
    }

    // --- Getters e Setters para atributos específicos de Contato ---
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        // Atualiza também a descrição na superclasse, para manter consistência
        super.setDescricao(nome);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(String dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        // Atributos herdados de ItemBase
        map.put("id", this.getId());
        map.put("descricao", this.getDescricao());
        map.put("dataCadastro", this.getDataCriacao());

        // Atributos específicos de Contato
        map.put("nome", this.nome);
        map.put("email", this.email);
        map.put("telefone", this.telefone);
        map.put("status", this.status);
        map.put("dataInativacao", this.dataInativacao);
        map.put("dataExclusao", this.dataExclusao);
        return map;
    }
}
