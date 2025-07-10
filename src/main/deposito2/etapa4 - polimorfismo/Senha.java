package com.example.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Senha extends ItemBase {
    private String url;
    private String senha; 
    private String status;

    public static List<Senha> senhas = new ArrayList<>();
    public static int proximoId = 1;

    public Senha(String id, String descricao, String url, String senha, String status, String dataAbertura) {
        super(id, descricao, dataAbertura);
        this.url = url;
        this.senha = senha;
        this.status = status;
    }

    // --- Getters e Setters para atributos específicos de Senha ---
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();

        // Atributos específicos de Senha
        map.put("url", this.url);
        map.put("senha", this.senha);
        map.put("status", this.status);
        return map;
    }
}
