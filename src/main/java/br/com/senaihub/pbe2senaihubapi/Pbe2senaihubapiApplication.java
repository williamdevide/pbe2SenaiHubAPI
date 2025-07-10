package br.com.senaihub.pbe2senaihubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicializa a aplicação Spring Boot.
 * <p>
 * A anotação @SpringBootApplication habilita a autoconfiguração do Spring,
 * a varredura de componentes no pacote atual e a configuração de beans.
 */
@SpringBootApplication
public class Pbe2senaihubapiApplication {

    /**
     * O ponto de entrada (entry point) da aplicação.
     * <p>
     * Este método delega ao SpringApplication a inicialização do contexto da aplicação,
     * criando o container de injeção de dependência e iniciando o servidor web embutido.
     *
     * @param args Argumentos de linha de comando passados para a aplicação, se houver.
     */
    public static void main(String[] args) { //
        SpringApplication.run(Pbe2senaihubapiApplication.class, args);
    }
}