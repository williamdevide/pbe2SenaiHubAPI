package com.example.projeto1.model;

public class Tarefa {
    private Long id;
    private String descricao;
    private boolean concluida;

    // Construtor
    public Tarefa(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = false;
    }

    // Getters e Setters (obrigatórios para o Spring Boot)
    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
}