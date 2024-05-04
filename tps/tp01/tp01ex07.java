//package tps.tp01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class tp01ex07 {
  private static String httpRequest(String url) {
    URL site;
    InputStream inputstream;
    BufferedReader bufferedReader;
    String response = "";
    String line;

    try {
      site = new URI(url).toURL();
      inputstream = site.openStream();
      bufferedReader = new BufferedReader(new InputStreamReader(inputstream));

      while ((line = bufferedReader.readLine()) != null) {
        response += line + "\n";
      }

      inputstream.close();
    } catch (Exception e) { }

    return response;
  }

  private static int[] contaLetra(String texto, char[] letras) {
    int[] letrasCont = new int[letras.length];

    for (int i = 0; i < texto.length(); i++)
      for (int j = 0; j < letras.length; j++)
        if (texto.charAt(i) == letras[j])
          letrasCont[j]++;

    return letrasCont;
  }

  private static int[] contaPalavra(String texto, String[] palavras) {
    int[] palavrasCont = new int[palavras.length];

    for (int i = 0; i < palavras.length; i++) {
      for (int j = 0; j < texto.length(); j++) {
        if (texto.charAt(j) == palavras[i].charAt(0) && j + palavras[i].length() < texto.length()) {
          int check = palavras[i].length();
          boolean ehIgual = true;

          for (int k = 0; k < check; k++) {
            if (palavras[i].charAt(k) != texto.charAt(j + k))
              ehIgual = false;
          }

          if (ehIgual) palavrasCont[i]++;
        }
      }
    }

    return palavrasCont;
  }


  private static void contaElementos(String url, String texto) {
    String textoSite = httpRequest(url);

    //char[] vogais = { 'a', 'e', 'i', 'o', 'u', 'á', 'é', 'í', 'ó', 'ú', 'à', 'è', 'ì', 'ò', 'ù', 'ã', 'õ', 'â', 'ê', 'î', 'ô', 'û' };
    char[] vogais = { 'a', 'e', 'i', 'o', 'u', '\u00E1', '\u00E9', '\u00ED', '\u00F3', '\u00FA', '\u00E0', '\u00E8', '\u00EC', '\u00F2', '\u00F9', '\u00E3', '\u00F5', '\u00E2', '\u00EA', '\u00EE', '\u00F4', '\u00FB' };
    char[] consoantes = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
    String[] tags = {"<br>", "<table>"};

    // vogais
    int[] contVogais = contaLetra(textoSite, vogais);

    // consoantes
    int[] contConsoantes = contaLetra(textoSite, consoantes);
    int totalConsoantes = 0;

    // tags
    int[] contTags = contaPalavra(textoSite, tags);
    contVogais[0] -= (1 * contTags[1]);
    contVogais[1] -= (1 * contTags[1]);
    totalConsoantes -= (3 * contTags[1]);
    totalConsoantes -= (2 * contTags[0]);


    for (int i = 0; i < vogais.length; i++)
      System.out.print(vogais[i] + "(" + contVogais[i] + ") ");

    for (int i = 0; i < contConsoantes.length; i++)
      totalConsoantes += contConsoantes[i];

    System.out.print("consoante(" + totalConsoantes + ") ");

    for (int i = 0; i < contTags.length; i++)
      System.out.print(tags[i] + "(" + contTags[i] + ") ");

    System.out.println(texto);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String texto = scanner.nextLine();
    String url;

    while (!texto.equals("FIM")) {
      url = scanner.nextLine();
      contaElementos(url, texto);

      texto = scanner.nextLine();
    }

    scanner.close();
  }
}
