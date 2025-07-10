package br.com.senaihub.pbe2senaihubapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa um contato na agenda. Herda de ItemBase.
 */
public class Contato extends ItemBase {
    private String nome;
    private String email;
    private String telefone;
    private String status;
    private String dataInativacao;
    private String dataExclusao;

    /**
     * Lista estática para armazenar os contatos em memória, simulando um banco de dados.
     */
    public static List<Contato> contatos = new ArrayList<>(); //

    /**
     * Contador estático para gerar o próximo ID de contato.
     */
    public static int proximoId = 1; //

    /**
     * Construtor para criar um novo objeto Contato.
     *
     * @param id           O ID único do contato.
     * @param nome         O nome do contato. A descrição na classe base também será o nome.
     * @param email        O e-mail do contato.
     * @param telefone     O telefone do contato.
     * @param status       O status atual do contato (ex: "ativo").
     * @param dataCadastro A data de criação do contato.
     */
    public Contato(String id, String nome, String email, String telefone, String status, String dataCadastro) { //
        super(id, nome, dataCadastro);
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.dataInativacao = "";
        this.dataExclusao = "";
    }

    /**
     * @return O nome do contato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do contato e atualiza a descrição na classe base.
     *
     * @param nome O novo nome do contato.
     */
    public void setNome(String nome) {
        this.nome = nome;
        super.setDescricao(nome);
    }

    /**
     * @return O e-mail do contato.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email O novo e-mail do contato.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return O telefone do contato.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone O novo telefone do contato.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return O status do contato.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status O novo status do contato.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return A data de inativação do contato.
     */
    public String getDataInativacao() {
        return dataInativacao;
    }

    /**
     * @param dataInativacao A nova data de inativação.
     */
    public void setDataInativacao(String dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    /**
     * @return A data de exclusão do contato.
     */
    public String getDataExclusao() {
        return dataExclusao;
    }

    /**
     * @param dataExclusao A nova data de exclusão.
     */
    public void setDataExclusao(String dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    /**
     * Sobrescreve o método toMap da classe base para incluir os atributos específicos de Contato.
     *
     * @return Um Map contendo todos os dados do contato para serialização.
     * @see ItemBase#toMap()
     */
    @Override
    public Map<String, String> toMap() { //
        Map<String, String> map = super.toMap();
        map.put("nome", this.nome);
        map.put("email", this.email);
        map.put("telefone", this.telefone);
        map.put("status", this.status);
        map.put("dataInativacao", this.dataInativacao);
        map.put("dataExclusao", this.dataExclusao);
        return map;
    }
}