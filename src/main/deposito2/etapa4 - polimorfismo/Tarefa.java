package com.example.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tarefa extends ItemBase {
    private String status;
    private String dataConclusao;
    private String dataExclusao;

    public static List<Tarefa> tarefas = new ArrayList<>();
    public static int proximoId = 1;

    public Tarefa(String id, String descricao, String status, String dataAbertura) {
        super(id, descricao, dataAbertura);
        this.status = status;
        this.dataConclusao = "";
        this.dataExclusao = "";
    }

    // --- Getters e Setters para atributos específicos de Tarefa ---
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(String dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();

        // Atributos específicos de Tarefa
        map.put("status", this.status);
        map.put("dataConclusao", this.dataConclusao);
        map.put("dataExclusao", this.dataExclusao);
        return map;
    }
}