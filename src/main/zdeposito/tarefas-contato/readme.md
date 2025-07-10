Exercício de Prática – Gerenciador de Contatos (Agenda)
Objetivo: Criar uma API REST em Java com Spring Boot para gerenciar uma lista de contatos, utilizando estrutura em memória com List<Map<String, String>>.

Especificação
Crie dois arquivos:
contatosModel.java → será usado para armazenar os dados em memória.
contatosController.java → conterá todos os endpoints da API.

Modelo de Dados do Contato
Cada contato será armazenado como um Map<String, String> com os seguintes campos:
id → identificador sequencial do contato (ex: 1, 2, 3…)
nome → nome completo do contato
email → e-mail válido
telefone → telefone no formato brasileiro (ex: (11) 91234-5678)
dataCadastro → data e hora do cadastro
status → "ativo" ou "inativo"

Operações (endpoints)
Implemente os seguintes endpoints:

Método	Rota	Descrição
GET	/api/contatos	Lista todos os contatos
GET	/api/contatos/{id}	Retorna um contato específico
POST	/api/contatos	Cria um novo contato
PUT	/api/contatos/{id}/inativar	Marca o contato como inativo
DELETE	/api/contatos/{id}	Remove o contato da lista

Regras
O id deve ser gerado automaticamente de forma sequencial.
O campo dataCadastro deve registrar a data/hora atual no momento da criação.
Se um contato não for encontrado, retorne uma mensagem de erro clara.
O campo status deve iniciar como "ativo".

