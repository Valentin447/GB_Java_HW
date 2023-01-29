// Задание 1.
// Создать список целых чисел (заполнить случайными числами), удалить из списка четные числа.

package HomeWork3;
import java.util.ArrayList;
import java.util.Random;

public class task1 {
  public static void main(String[] args) {
    ArrayList<Integer> myList = new ArrayList<Integer>();
    Random ranNumber = new Random();
    for(int i = 0; i < 20; i++){
      myList.add(ranNumber.nextInt(10));
    }
    System.out.println("до " + myList);
    for(int item = 0; item < myList.size();){
      if(myList.get(item) % 2 == 0){
        myList.remove(item);
      } else {
        item ++;
      }
    }
    System.out.println("после " + myList);
  }
}
