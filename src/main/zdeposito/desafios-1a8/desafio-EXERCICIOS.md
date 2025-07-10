OS NOMES DAS FUNÇÕES DEVEM TER O MESMO NOME DO ENDPOINT
SUBSTITUA O NOME WILLIAM NOS SEUS CÓDIGOS PELO SEU NOME NO MOMENTO DA EXECUÇÃO

DESAFIO 1
- CRIE O ARQUIVO arquivoDesafio1.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio1
- RETORNE "Seja bem vindo aos desafios de Backend."

DESAFIO 2
- CRIE O ARQUIVO arquivoDesafio2.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio2/{nome}
- RETORNE "William, parábens. Você utilizou um endpoint variável."

DESAFIO 3
- CRIE O ARQUIVO arquivoDesafio3.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio3?nome="William"
- RETORNE "William, parábens. Agora você utilizou um endpoint fixo."

DESAFIO 4
- CRIE O ARQUIVO arquivoDesafio4.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio4?nome="William"&cpf="11122233344"
- VERIFIQUE SE O CPF INFORMADO TEM 11 DÍGITOS NUMÉRICOS (não precisa validar se é real)
- RETORNE "William, CPF válido." OU "William, CPF inválido."

DESAFIO 5
- CRIE O ARQUIVO arquivoDesafio5.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio5?nome="William"&idade="43"
- RETORNE "William você é Criança" (idade entre 0 e 12 anos)
- RETORNE "William você é Adolescente" (idade entre 13 e 17 anos)
- RETORNE "William você é Adulto" (idade entre 18 e 64 anos)
- RETORNE "William você é Idoso" (idade entre 65 e 100 anos)
- RETORNE "William Idade inválida." (fora desses valores)
- RETORNE "Olá, você não informou seu nome." (caso não seja passado o nome)
- RETORNE "Olá, você não informou sua idade." (caso não seja passado a idade)

DESAFIO 6
- CRIE O ARQUIVO arquivoDesafio6.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio6/{nome}
- CASO SEJA PASSADO O NOME RETORNA UM JSON COM A TAG "NOME": NOME
- CASO NÃO SEJA PASSADO O NOME RETORNA UM JSON COM A TAG "ERRO": "NOME NÃO INFORMADO"

DESAFIO 7
- CRIE O ARQUIVO arquivoDesafio7.java
- CRIE UM OBJETO LIST.MAP CHAMADO ALUNOS COM NOME
- CRIE 5 CADASTROS DENTRO DO OBJETO LIST.MAP
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio7listar
- RETORNE UM JSON COM TODOS OS REGISTROS DO OBJETO ALUNOS CORRESPONDENTE
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio7pesquisar?nome={nome}
- RETORNE UM JSON COM O REGISTRO DO OBJETO ALUNOS CORRESPONDENTE
- RETORNE UM JSON COM O REGISTRO "erro":"nao encontrado" CASO NÃO LOCALIZE O ALUNO

DESAFIO 8
- CRIE O ARQUIVO arquivoDesafio8.java
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio8?nome={nome}&idade={idade}&curso={curso}
- CRIE UM OBJETO LIST.MAP CHAMADO ALUNOS COM NOME, CURSO, IDADE
- CRIE 5 CADASTROS DENTRO DO OBJETO LIST.MAP
- RETORNE UM JSON COM O REGISTRO DO OBJETO ALUNOS CORRESPONDENTE
- FAÇA A BUSCA PELO CAMPO INFORMADO, CASO SEJA INFORMADO MAIS DE UM CAMPO PODE SER PELO PRIMEIRO