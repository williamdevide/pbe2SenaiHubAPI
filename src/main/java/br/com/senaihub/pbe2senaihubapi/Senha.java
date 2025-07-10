package br.com.senaihub.pbe2senaihubapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa uma credencial (senha) armazenada. Herda de ItemBase.
 */
public class Senha extends ItemBase {
    private String url;
    private String senha;
    private String status;

    /**
     * Lista estática para armazenar as senhas em memória.
     */
    public static List<Senha> senhas = new ArrayList<>(); //

    /**
     * Contador estático para gerar o próximo ID de senha.
     */
    public static int proximoId = 1; //

    /**
     * Construtor para criar um novo objeto Senha.
     *
     * @param id           O ID único da credencial.
     * @param descricao    Uma descrição para a credencial (ex: "E-mail Pessoal").
     * @param url          A URL do serviço associado.
     * @param senha        A senha a ser armazenada.
     * @param status       O status da credencial.
     * @param dataAbertura A data de criação.
     */
    public Senha(String id, String descricao, String url, String senha, String status, String dataAbertura) { //
        super(id, descricao, dataAbertura);
        this.url = url;
        this.senha = senha;
        this.status = status;
    }

    /**
     * @return A URL associada à senha.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url A nova URL.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return A senha armazenada.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha A nova senha.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return O status da senha.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status O novo status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sobrescreve o método toMap para incluir os atributos específicos de Senha.
     *
     * @return Um Map contendo todos os dados da senha.
     * @see ItemBase#toMap()
     */
    @Override
    public Map<String, String> toMap() { //
        Map<String, String> map = super.toMap();
        map.put("url", this.url);
        map.put("senha", this.senha);
        map.put("status", this.status);
        return map;
    }
}