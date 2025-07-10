package br.com.senaihub.pbe2senaihubapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representa uma tarefa a ser realizada. Herda de ItemBase.
 */
public class Tarefa extends ItemBase {
    private String status;
    private String dataConclusao;
    private String dataExclusao;

    /**
     * Lista estática para armazenar as tarefas em memória.
     */
    public static List<Tarefa> tarefas = new ArrayList<>(); //

    /**
     * Contador estático para gerar o próximo ID de tarefa.
     */
    public static int proximoId = 1; //

    /**
     * Construtor para criar um novo objeto Tarefa.
     *
     * @param id          O ID único da tarefa.
     * @param descricao   A descrição do que precisa ser feito.
     * @param status      O status atual da tarefa (ex: "aberta", "concluida").
     * @param dataAbertura A data de criação da tarefa.
     */
    public Tarefa(String id, String descricao, String status, String dataAbertura) { //
        super(id, descricao, dataAbertura);
        this.status = status;
        this.dataConclusao = "";
        this.dataExclusao = "";
    }

    /**
     * @return O status da tarefa.
     */
    public String getStatus() { //
        return status;
    }

    /**
     * @param status O novo status da tarefa.
     */
    public void setStatus(String status) { //
        this.status = status;
    }

    /**
     * @return A data de conclusão da tarefa.
     */
    public String getDataConclusao() { //
        return dataConclusao;
    }

    /**
     * @param dataConclusao A nova data de conclusão.
     */
    public void setDataConclusao(String dataConclusao) { //
        this.dataConclusao = dataConclusao;
    }

    /**
     * @return A data de exclusão da tarefa.
     */
    public String getDataExclusao() { //
        return dataExclusao;
    }

    /**
     * @param dataExclusao A nova data de exclusão.
     */
    public void setDataExclusao(String dataExclusao) { //
        this.dataExclusao = dataExclusao;
    }

    /**
     * Sobrescreve o método toMap para incluir os atributos específicos de Tarefa.
     *
     * @return Um Map contendo todos os dados da tarefa.
     * @see ItemBase#toMap()
     */
    @Override
    public Map<String, String> toMap() { //
        Map<String, String> map = super.toMap();
        map.put("status", this.status);
        map.put("dataConclusao", this.dataConclusao);
        map.put("dataExclusao", this.dataExclusao);
        return map;
    }
}