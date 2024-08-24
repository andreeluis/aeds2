import java.util.Arrays;
import java.util.Scanner;

public class EX1566 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nc = sc.nextInt();

    for (int i = 0; i < nc; i++) {
      int n = sc.nextInt();

      int[] arr = new int[n];
      for (int j = 0; j < n; j++) {
        arr[j] = sc.nextInt();
      }

      Arrays.sort(arr);

      for (int j = 0; j < n; j++) {
        System.out.print(arr[j] + " ");
      }
      System.out.println();
    }

    sc.close();
  }
}
