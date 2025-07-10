DESAFIO 1
- CRIE O ARQUIVO DESAFIO1.JAVA
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio1/{nome}
- CASO SEJA PASSADO O NOME RETORNA UM JSON COM A TAG "NOME": NOME
- CASO NÃO SEJA PASSADO O NOME RETORNA UM JSON COM A TAG "ERRO": "NOME NÃO INFORMADO"

DESAFIO 2
- CRIE O ARQUIVO DESAFIO2.JAVA
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio2?nome={nome}&idade={idade}
- RETORNE "William você é Criança" (idade entre 0 e 12 anos),
- RETORNE "William você é Adolescente" (idade entre 13 e 17 anos),
- RETORNE "William você é Adulto" (idade entre 18 e 64 anos),
- RETORNE "William você é Idoso" (idade entre 65 e 100 anos).
- RETORNE "William Idade inválida." (fora desses valores)
- RETORNE "Olá, você não informou seu nome." (caso não seja passado o nome)

DESAFIO 3
- CRIE O ARQUIVO DESAFIO3.JAVA
- A CHAMADA (ENDPOINT) DEVE SER FEITA COM /desafio3?nome={nome}&idade={idade}&curso={curso}
- CRIE UM OBJETO LIST.MAP CHAMADO ALUNOS COM NOME, CURSO, IDADE
- RETORNE UM JSON COM O REGISTRO DO OBJETO ALUNOS CORRESPONDENTE
- FAÇA A BUSCA SOMENTE PELO CAMPO INFORMADO
