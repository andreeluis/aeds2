import java.util.Scanner;

class Carro {
  int chegada;
  int saida;

  public Carro(int chegada, int saida) {
    this.chegada = chegada;
    this.saida = saida;
  }
}

class Estacionamento {
  int capacidadeCarros;
  int utilizado;
  Carro[] carros;

  public Estacionamento(int capac) {
    this.capacidadeCarros = capac;
    this.utilizado = 0;
    this.carros = new Carro[capac];
  }

  public boolean inserir(int chegada, int saida) {
    // System.out.printf("chegou %d e vai sair %d", chegada, saida);

    if (utilizado == 0) {
      carros[utilizado++] = new Carro(chegada, saida);
      return true;
    }

    if (carros[utilizado - 1].saida <= chegada) {
      // carro na ultima posição sai antes do outro chegar
      carros[--utilizado] = null;
    }

    if (utilizado == capacidadeCarros) {
      // estacionamento cheio
      return false;
    } else {
      // vaga no estacionamento, verificar compatibilidade de horarios
      if (carros[utilizado - 1].saida > saida) {
        carros[utilizado++] = new Carro(chegada, saida);
        return true;
      }

      return false;
    }
  }
}

public class BEE1523 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    while (n != 0 && k != 0) {
      Estacionamento est = new Estacionamento(k);
      boolean resp = true;

      for (int i = 0; i < n; i++) {
        int c = sc.nextInt();
        int s = sc.nextInt();

        if (!est.inserir(c, s)) {
          resp = false;
        }
      }

      if (resp)
        System.out.println("Sim");
      else
        System.out.println("Nao");

      n = sc.nextInt();
      k = sc.nextInt();
    }

    sc.close();
  }
}
