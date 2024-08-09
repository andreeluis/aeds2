# Trabalho Prático 02
O arquivo characters.csv contém um conjunto de dados de personagens da série extraídos do site https://www.kaggle.com/. Essa base contém registros de 405 personagens. Este arquivo sofreu algumas adaptações para ser utilizado neste e nos próximos trabalhos práticos. Tal arquivo deve ser copiado para a pasta /tmp/. Quando reiniciamos o Linux, ele normalmente apaga os arquivos existentes na pasta /tmp/.

Implemente os itens pedidos a seguir:

1. **Classe em Java** - Crie uma classe Personagem seguindo todas as regras apresentadas no slide [unidade001_conceitosBasicos_introducaoOO.pdf](https://github.com/icei-pucminas/aeds2/blob/master/aulas/u00%20Nivelamento/unidade00l_nivelamento_introducaoOO.pdf). Sua classe terá os atributos privados *id* (String), *name* (String), *alternateNames* (Lista), *house* (String), *ancestry* (String), *species* (String), *patronus* (String), *hogwartsStaff* (Boolean), *hogwartsStudent* (String), *actorName* (String), *alive* (Boolean), *dateOfBirth* (DateTime), *yearOfBirth* (int), *eyeColour* (String), *gender* (String), *hairColour* (String), *wizard* (Boolean). Sua classe também terá pelo menos dois construtores, e os métodos gets, sets, clone, imprimir e ler.
	Atenção para o arquivo de entrada, pois em alguns registros faltam valores e esse foi substituído pelo valor 0 (zero) ou vazio.
	A entrada padrão é composta por varias linhas e cada uma contem uma string indicando o id do Personagem a ser lido. A ultima linha da entrada contém a palavra FIM. A saída padrão também contem varias linhas, uma para cada registro contido em uma linha da entrada padrão.
2. **Registro em C** - Repita a anterior criando o registro Personagem na linguagem C.
## Pesquisa
3. **Pesquisa Sequencial (JAVA)** - Faça a inserção de alguns registros no final de um vetor e, em seguida, faça algumas pesquisas sequenciais. A chave primaria de pesquisa sera o atributo *name*. A entrada padrão e composta por duas partes onde a primeira é igual a entrada da primeira questão. As demais linhas correspondem a segunda parte. A segunda parte é composta por várias linhas. Cada uma possui um elemento que deve ser pesquisado no vetor. A última linha terá a palavra FIM. A saída padrão será composta por várias linhas contendo as palavras SIM/NAO para indicar se existe cada um dos elementos pesquisados.
4. **Pesquisa Binária em C** - Repita a questão anterior, contudo, usando a Pesquisa Binária. A entrada e a saída padrão serão iguais as da questão anterior. A entrada desta questão não está ordenada.
## Ordenação
5. **Ordenação por Seleção (JAVA)** - Usando vetores, implemente o algoritmo de ordenação por seleção considerando que a chave de pesquisa é o atributo *name*. A entrada e a saída padrão são iguais as da primeira questão, contudo, a saída corresponde aos registros ordenados.
6. **Ordenação por Seleção Recursiva em C** - Repita a questão anterior, contudo, usando a Seleção Recursiva. A entrada e a saída padrão serão iguais as da questão anterior.
7. **Ordenação por Inserção (JAVA)** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo de Inserção, fazendo com que a chave de pesquisa seja o atributo *dateOfBirth*. (Lembre-se: em caso de empate, o critério de ordenação deverá ser o atributo *name*)
8. **Shellsort em C** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Shellsort, fazendo com que a chave de pesquisa seja o atributo *eyeColour*.
9. **Heapsort (JAVA)** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Heapsort, fazendo com que a chave de pesquisa seja o atributo hairColour.
10. **Quicksort em C** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Quicksort, fazendo com que a chave de pesquisa seja o atributo *house*.
11. **Counting Sort  (JAVA)** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Counting Sort, fazendo com que a chave de pesquisa seja o atributo *yearOfBirth*.
12. **Bolha em C** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo da Bolha, fazendo com que a chave de pesquisa seja o atributo hairColour.
13. **Mergesort (JAVA)** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Mergesort, fazendo com que a chave de pesquisa seja o atributo *actorName*.
14. **Radixsort em C** - Repita a questão de Ordenação por Seleção, contudo, usando o algoritmo Radixsort, fazendo com que a chave de pesquisa seja o atributo *id*.
15. **Ordenação PARCIAL por Seleção (JAVA)** - Repita a questão de Ordenação por Seleção considerando a ordenação parcial com k igual a 10.
16. **Ordenação PARCIAL por Inserção em C** - Repita a questão de Ordenação por Inserção considerando a ordenação parcial com k igual a 10.
17. **Heapsort PARCIAL em C** - Repita a questão “Heapsort” considerando a ordenação parcial com k igual a 10.
18. **Quicksort PARCIAL (JAVA)** - Repita a questão “Quicksort” considerando a ordenação parcial com k igual a 10.
