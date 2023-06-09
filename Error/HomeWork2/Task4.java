// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String str = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        str = sc.nextLine();
        if(str == "") {
            throw new RuntimeException("Пустые строки вводить нельзя");
        } else {
            System.out.println(str);
        }
    }
}
