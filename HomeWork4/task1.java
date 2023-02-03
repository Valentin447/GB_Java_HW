// Создать LinkedList целых чисел (заполнить случайными числами).
// Реализуйте метод, который вернет “перевернутый” список.

package HomeWork4;

import java.util.Random;
import java.util.LinkedList;

public class task1 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    Random rand = new Random();
    for (int i = 0; i < 5; i++) {
      list.add(rand.nextInt(10));
    }
    System.out.println("Начальный список: " + list);
    System.out.println("Конечный список: " + getReverseList(list));
  }

  public static LinkedList<Integer> getReverseList(LinkedList<Integer> startList) {
    LinkedList<Integer> resList = new LinkedList<Integer>();
    for (Integer item : startList) {
      resList.addFirst(item);
    }
    return resList;
  }
}
