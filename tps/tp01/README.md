# Trabalho Prático 01

1. **Palíndromo (JAVA)** - Crie um método iterativo que recebe uma string como parâmetro e retorna true se essa e um palíndromo. Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM / NAO indicando se a linha e um palíndromo. Destaca-se que uma linha de entrada pode ter caracteres não letras.
2. **Palíndromo em C**
3. **Ciframento de César (JAVA)** - O Imperador Julio Cesar foi um dos principais nomes do Império Romano. Entre suas contribuições, temos um algoritmo de criptografia chamado "Ciframento de César". Segundo os historiadores, César utilizava esse algoritmo para criptografar as mensagens que enviava aos seus generais durante as batalhas. A ideia básica e um simples deslocamento de caracteres. Assim, por exemplo, se a chave utilizada para criptografar as mensagens for 3, todas as ocorrências do caractere a são substituídas pelo caractere d, as do b por e, e assim sucessivamente. Crie um método **iterativo** que recebe uma string como parâmetro e retorna outra contendo a entrada de forma cifrada. Neste exercício, suponha a chave de ciframento três. Na saída padrão, para cada linha de entrada, escreva uma linha com a mensagem criptografada.
4. **Alteração Aleatória (JAVA)** - Crie um método iterativo que recebe uma string, sorteia duas letras minúsculas aleatórias (código ASCII >= 'a' e ,= 'z'), substitui todas as ocorrências da primeira letra na string pela segunda e retorna a string com as alterações efetuadas. Na saída padrão, para cada linha de entrada, execute o método desenvolvido nesta questão e mostre a string retornada como uma linha de saída. Abaixo, observamos um exemplo de entrada supondo que para a primeira linha as letras sorteados foram o a e o q. Para a segunda linha, foram o e e o k.
	```
	# EXEMPLO DE ENTRADA
	o rato roeu a roupa do rei de roma
	e qwe qwe qwe ewq ewq ewq
	FIM
	```
 	```
	# EXEMPLO DE SAÍDA
	o rqto roeu q roupq do rei de romq
	k qwk qwk qwk kwq kwq kwq
	FIM
	```
	A classe Random do Java gera números (ou letras) aleatórios e o exemplo abaixo mostra uma letra minúscula na tela. Em especial, destacamos que: i) seed e a semente para geração de números aleatórios; ii) nesta questão, por causa da correção automática, a seed sera quatro; iii) a disciplina de Estatística e Probabilidade faz uma discussão sobre aleatório.
	```java
	Random gerador = new Random();
	gerador.setSeed(4);
	System.out. println((char)( a + (Math.abs(gerador.nextInt()) % 26)));
	```
5. **Álgebra Booleana (JAVA)** - Crie um método iterativo que recebe uma string contendo uma expressão booleana e o valor de suas entradas e retorna um booleano indicando se a expressão e verdadeira ou falsa. Cada string de entrada e composta por um numero inteiro n indicando o numero de entradas da expressão booleana corrente. Em seguida, a string contem n valores binários (um para cada entrada) e a expressão booleana. Na saída padrão, para cada linha de entrada, escreva uma linha de saída com SIM / NAO indicando se a expressão corrente e verdadeira ou falsa.
6. **Is (JAVA)** - Crie um método iterativo que recebe uma string e retorna true se a mesma e composta somente por vogais. Crie outro método iterativo que recebe uma string e retorna true se a mesma e composta somente por consoantes. Crie um terceiro método iterativo que recebe uma string e retorna true se a mesma corresponde a um numero inteiro. Crie um quarto método iterativo que recebe uma string e retorna true se a mesma corresponde a um numero real. Na saída padrão, para cada linha de entrada, escreva outra de saída da seguinte forma X1 X2 X3 X4 onde cada Xi e um booleano indicando se a e entrada e: composta somente por vogais (X1); composta somente somente por consoantes (X2); um numero inteiro (X3); um numero real (X4). Se Xi for verdadeiro, seu valor sera SIM, caso contrario, NAO.
7. **Leitura de Pagina HTML (JAVA)** - Leia duas strings sendo que a primeira e o nome de uma pagina web e a segunda, seu endereço. Por exemplo, Pontifícia Universidade Católica de Minas Gerais e www.pucminas.br . Em seguida, mostre na tela o numero de vogais (sem e com acento), consoantes e dos padrões "< br >" e "< table >" que aparecem no código dessa pagina. A entrada padrão e composta por varias linhas. Cada uma contem varias strings sendo que a primeira e um endereço web e as demais o nome dessa pagina web. A ultima linha da entrada padrão contem a palavra FIM. A saída padrão contem varias linhas sendo que cada uma apresenta o numero de ocorrência (valor xi entre parênteses) de cada caractere ou string solicitado. Cada linha de saída sera da seguinte forma: a(x1) e(x2) i(x3) o(x4) u(x5) á(x6) é(x7) í(x8) ó(x9) ú(x10) à(x11) è(x12) ì(x13) ò(x14) ù(x15) ã(x16) õ(x17) â(x19) ê(x19) î(x20) ô(x21) û(x22) consoante(x23) < br >(x24) < table >(x25) nomePágina(x26).
8. **Arquivo (JAVA)** - Faça um programa que leia um numero inteiro n indicando o numero de valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto. Apos a leitura dos valores, devemos fechar o arquivo. Em seguida, reabri-lo e fazer a leitura de tras para frente usando os metodos getFilePointer e seek da classe RandomAccessFile e mostre todos os valores lidos na tela. Nessa questao, voce nao pode usar, arrays, strings ou qualquer estrutura de dados. A entrada padrão e composta por um numero inteiro n e mais n números reais. A saída padrão corresponde a n números reais mostrados um por linha de saída.
9. **Arquivo em C**
10. **RECURSIVO - Palíndromo**
11. **RECURSIVO - Palíndromo em C**
12. **RECURSIVO - Ciframento de Cesar**
13. **RECURSIVO - Alteração Aleatória em C**
14. **RECURSIVO - Álgebra Booleana**
15. **RECURSIVO - Is**
