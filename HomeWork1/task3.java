// Реализовать простой калькулятор (операции + - / * )

package HomeWork1;

import java.util.Scanner;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;

public class task3 {
  public static void main(String[] args) {
    Scanner iScanner = new Scanner(System.in);
    double n1 = 0;
    double n2 = 0;
    boolean isExcept = false;
    do {
      try {
        System.out.printf("Введите первое число: ");
        n1 = Double.parseDouble(iScanner.nextLine());
        System.out.printf("Введите второе число: ");
        n2 = Double.parseDouble(iScanner.nextLine());
        isExcept = false;
      } catch (NumberFormatException ex) {
        System.out.println("Введино не корректное значение!");
        isExcept = true;
      }
    } while (isExcept);

    System.out.print("Введите операцию '+'  '-'  '*'  '/': ");
    String operation = iScanner.nextLine();
    iScanner.close();
    DecimalFormat dFormat = new DecimalFormat("#.#####");
    switch (operation) {
      case ("+"):
        System.out.printf("%s + %s = %s", dFormat.format(n1), dFormat.format(n2), dFormat.format(n1 + n2));
        break;
      case ("-"):
        System.out.printf("%s - %s = %s", dFormat.format(n1), dFormat.format(n2), dFormat.format(n1 - n2));
        break;
      case ("*"):
        System.out.printf("%s * %s = %s", dFormat.format(n1), dFormat.format(n2), dFormat.format(n1 * n2));
        break;
      case ("/"):
        if (n2 == 0) {
          System.out.print("Нельзя делить на ноль!");
        } else {
          System.out.printf("%s / %s = %s", dFormat.format(n1), dFormat.format(n2), dFormat.format(n1 / n2));
        }
        break;
      default:
        System.out.print("Введина не корректная операция!");
    }
  }
}
