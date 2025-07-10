package br.com.senaihub.pbe2senaihubapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa uma nota de texto. Herda de ItemBase.
 */
public class Nota extends ItemBase {
    private String conteudo;
    private String status;

    /**
     * Lista estática para armazenar as notas em memória.
     */
    public static List<Nota> notas = new ArrayList<>(); //

    /**
     * Contador estático para gerar o próximo ID de nota.
     */
    public static int proximoId = 1; //

    /**
     * Construtor para criar um novo objeto Nota.
     *
     * @param id           O ID único da nota.
     * @param descricao    O título ou breve descrição da nota.
     * @param conteudo     O conteúdo principal da nota.
     * @param status       O status atual da nota (ex: "aberta").
     * @param dataAbertura A data de criação da nota.
     */
    public Nota(String id, String descricao, String conteudo, String status, String dataAbertura) { //
        super(id, descricao, dataAbertura);
        this.conteudo = conteudo;
        this.status = status;
    }

    /**
     * @return O conteúdo da nota.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo O novo conteúdo da nota.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * @return O status da nota.
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status O novo status da nota.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sobrescreve o método toMap para incluir os atributos específicos de Nota.
     *
     * @return Um Map contendo todos os dados da nota.
     * @see ItemBase#toMap()
     */
    @Override
    public Map<String, String> toMap() { //
        Map<String, String> map = super.toMap();
        map.put("conteudo", this.conteudo);
        map.put("status", this.status);
        return map;
    }
}