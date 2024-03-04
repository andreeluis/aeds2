// Palindromo recursivo

import java.util.Scanner;

public class tp01ex10 {
  private static Boolean palindromo(String texto, int i) {
    Boolean resp;

    if (texto.length() == i)
      resp = true;
    else if (texto.charAt(i) != texto.charAt(texto.length() - 1 - i))
      resp = false;
    else
      resp = palindromo(texto, ++i);

    return resp;
  }

	private static Boolean ehPalindromo(String texto) {
		return palindromo(texto, 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String texto;

		texto = sc.nextLine();

		while (!texto.equals("FIM")) {
			if (ehPalindromo(texto))
				System.out.println("SIM");
			else
				System.out.println("NAO");

			texto = sc.nextLine();
		}

		sc.close();
	}
}
