// Создать очередь с помощью LinkedList и реализовать следующие методы:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
// Вызвать полученные методы и убедиться в их работоспособности.

package HomeWork4;

import java.util.Random;
import java.util.LinkedList;

public class task2 {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    Random rand = new Random();
    for (int i = 0; i < 5; i++) {
      list.add(rand.nextInt(10));
    }
    System.out.println("Начальный список: " + list);
    enqueue(list, 11);
    enqueue(list, 12);
    System.out.println("После добавления двух элементов: " + list);
    System.out.printf("Поучаем первый элемент %s и удаляем его из очереди %s\n", dequeue(list), list);
    System.out.printf("Поучаем первый элемент %s не удаляя %s\n", first(list), list);

  }

  public static void enqueue(LinkedList<Integer> list, Integer item) {
    list.addLast(item);
  }

  public static Integer dequeue(LinkedList<Integer> list) {
    Integer item = list.pollFirst();
    return item;
  }

  public static Integer first(LinkedList<Integer> list) {
    Integer item = list.peekFirst();
    return item;
  }
}
