/// Задание 2:
// Создать список целых чисел (заполнить случайными числами).
// Найти минимальное, максимальное и среднее из этого списка.

package HomeWork3;

import java.util.ArrayList;
import java.util.Random;

public class task2 {
  public static void main(String[] args) {
    ArrayList<Integer> myList = new ArrayList<Integer>();
    Random ranNumber = new Random();
    for (int i = 0; i < 10; i++) {
      myList.add(ranNumber.nextInt(100));
    }
    System.out.println(myList);
    int myMax = myList.get(0);
    int myMin = myList.get(0);
    int mySum = 0;
    for (int i : myList) {
      if (i > myMax) {
        myMax = i;
      }
      if (i < myMin) {
        myMin = i;
      }
      mySum += i;
    }
    System.out.printf("Max: %s; Min: %s; Среднее: %s", myMax, myMin, mySum / myList.size());
  }
}
