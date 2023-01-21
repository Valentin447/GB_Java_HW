// Вычислить сумму чисел от 1 до n, вычислить n! произведение чисел от 1 до n

package HomeWork1;

import java.util.Scanner;
import java.lang.NumberFormatException;

public class task1 {
  public static void main(String[] args) {
    Scanner iScanner = new Scanner(System.in);
    int n = 0;
    boolean isExcept = false;
    do {
      System.out.printf("Введите целое число: ");
      try {
        n = Integer.parseInt(iScanner.nextLine());
        isExcept = false;
      } catch (NumberFormatException ex) {
        System.out.println("Введино не корректное значение!");
        isExcept = true;
      }
    } while (isExcept);

    int sum = 1;
    int mult = 1;
      for (int i = 2; i <= n; i++) {
        sum += i;
        mult *= i;
      }
    System.out.printf("Сумма: %s%n", sum);
    System.out.printf("Произведение: %s", mult);
    iScanner.close();
  }
}
