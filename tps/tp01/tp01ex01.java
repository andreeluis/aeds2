import java.util.Scanner;

class tp01ex01 {
	private static Boolean ehPalindromo(String texto) {
		int tam = texto.length() - 1;

		char[] textoArray = texto.toCharArray();

		for (int i = 0; i <= tam; i++) {
			if (textoArray[i] != textoArray[tam - i])
				return false;
		}

		return true;
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
