// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(getFloat());
    }

    public static float getFloat() {
        while (true) {
            System.out.println("Введите дробное число через запятую ");
            float number = 0;
            try {
                Scanner sc = new Scanner(System.in);
                number = sc.nextFloat();
                return number;
            } catch (Exception e) {
                System.out.println("Введино не корректное значение.");
            }
        }
    }
}
