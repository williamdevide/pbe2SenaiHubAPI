# PBE2 SENAI Hub API 🚀

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.4-green?style=for-the-badge&logo=spring)
![Maven](https://img.shields.io/badge/Maven-4.0.0-red?style=for-the-badge&logo=apache-maven)
![Status](https://img.shields.io/badge/status-em_desenvolvimento-yellow?style=for-the-badge)

> API Hub de Serviços desenvolvida para a disciplina de Programação Back-end 2 (PBE2) do SENAI. O projeto serve como uma central para gerenciar diferentes tipos de informações, como Contatos, Tarefas, Notas e Senhas, através de uma API RESTful.

Este projeto foi construído com foco no aprendizado de conceitos fundamentais de desenvolvimento back-end, incluindo:
* Arquitetura REST
* Padrões de Orientação a Objetos (Herança e Polimorfismo)
* Injeção de Dependências com Spring Boot
* Persistência de dados em memória
* Documentação de código com Javadoc

## ✨ Funcionalidades Principais

* ✅ **Gestão de Contatos:** CRUD completo para a agenda de contatos.
* ✅ **Gestão de Tarefas:** Crie, liste, conclua e exclua tarefas.
* ✅ **Gestão de Notas:** Armazene e gerencie anotações de texto.
* ✅ **Gestão de Senhas:** Guarde credenciais de forma organizada.
* ✅ **Endpoint Unificado:** Um endpoint especial que lista todos os tipos de itens, demonstrando polimorfismo na prática.

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.4.4** (com dependência `spring-boot-starter-web`)
* **Maven** (para gerenciamento de dependências e build)

## ▶️ Como Executar Localmente

Siga os passos abaixo para executar a API em seu ambiente local.

### Pré-requisitos

* **Java Development Kit (JDK) 21** ou superior.
* **Apache Maven** instalado e configurado no PATH.
* Um editor de código de sua preferência (ex: VS Code, IntelliJ IDEA).

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO_GIT]
    ```

2.  **Navegue até a pasta do projeto:**
    ```bash
    cd pbe2senaihubapi
    ```

3.  **Execute o projeto com o Maven:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Pronto!** A API estará rodando e acessível em `http://localhost:8080`.

## 📚 Documentação da API

A seguir estão os endpoints disponíveis na API. Para as requisições `POST` e `PUT`, o corpo (body) deve ser enviado em formato JSON.

### `/api/contatos`
| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/listar` | Lista todos os contatos. Aceita `?status=ativo` para filtrar. |
| `GET` | `/buscar/{id}` | Busca um contato pelo seu ID. |
| `POST` | `/criar` | Cria um novo contato. |
| `PUT` | `/{id}/atualizar` | Atualiza os dados de um contato existente. |
| `PUT` | `/{id}/inativar` | Marca um contato como inativo. |
| `DELETE`| `/{id}/excluir` | Exclui um contato permanentemente. |

### `/api/tarefas`
| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/listar` | Lista todas as tarefas. Aceita `?status=aberta` para filtrar. |
| `GET` | `/buscar/{id}` | Busca uma tarefa pelo seu ID. |
| `POST` | `/criar` | Cria uma nova tarefa. |
| `PUT` | `/{id}/concluir` | Marca uma tarefa como concluída. |
| `DELETE`| `/{id}/excluir` | Realiza a exclusão lógica (soft delete) de uma tarefa. |

### `/api/notas`
| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/listar` | Lista todas as notas. |
| `GET` | `/buscar/{id}` | Busca uma nota pelo seu ID. |
| `POST` | `/criar` | Cria uma nova nota. |
| `PUT` | `/{id}/atualizar` | Atualiza uma nota existente. |
| `DELETE`| `/{id}/excluir` | Exclui uma nota permanentemente. |

### `/api/senhas`
| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/listar` | Lista todas as senhas. |
| `GET` | `/buscar/{id}` | Busca uma senha pelo seu ID. |
| `POST` | `/criar` | Cria uma nova senha. |
| `PUT` | `/{id}/atualizar` | Atualiza uma senha existente. |
| `DELETE`| `/{id}/excluir` | Exclui uma senha permanentemente. |

### `/api/itens`
| Método HTTP | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/listar` | Lista **todos os itens** de todos os tipos em uma única chamada. |

## ☁️ Deploy

Esta API está configurada para deploy na plataforma [Render](https://render.com/).

**URL da API:** (adicione a URL pública aqui após o deploy)

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---
**Desenvolvido com ❤️ pelos alunos de Análise e Desenvolvimento de Sistemas do SENAI.**