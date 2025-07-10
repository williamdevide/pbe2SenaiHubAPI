package br.com.senaihub.pbe2senaihubapi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Representa a base para todos os itens gerenciáveis na aplicação.
 * <p>
 * Esta classe contém os atributos e métodos comuns que são herdados
 * por outras classes de modelo, como Contato, Nota, e Senha,
 * promovendo a reutilização de código.
 */
public class ItemBase {
    protected String id;
    protected String descricao;
    protected String dataCriacao;

    /**
     * Construtor para inicializar um novo ItemBase.
     *
     * @param id          O identificador único do item.
     * @param descricao   Uma breve descrição do item.
     * @param dataCriacao A data e hora em que o item foi criado.
     */
    public ItemBase(String id, String descricao, String dataCriacao) { //
        this.id = id;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    /**
     * Retorna o ID do item.
     *
     * @return O ID do item.
     */
    public String getId() {
        return id;
    }

    /**
     * Retorna a descrição do item.
     *
     * @return A descrição do item.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Retorna a data de criação do item.
     *
     * @return A data de criação formatada como String.
     */
    public String getDataCriacao() {
        return dataCriacao;
    }

    /**
     * Define a descrição do item, convertendo-a para maiúsculas.
     *
     * @param descricao A nova descrição para o item.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    /**
     * Retorna a data e hora atuais, formatadas como "dd/MM/yyyy HH:mm:ss".
     *
     * @return Uma String com a data e hora atuais.
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    /**
     * Converte os atributos do objeto para um Map.
     * <p>
     * Este método é fundamental para a serialização em JSON nas respostas da API.
     *
     * @return Um Map contendo os dados do item base (id, descricao, dataCriacao).
     */
    public Map<String, String> toMap() { //
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("id", this.id);
        map.put("descricao", this.descricao);
        map.put("dataCriacao", this.dataCriacao);
        return map;
    }
}