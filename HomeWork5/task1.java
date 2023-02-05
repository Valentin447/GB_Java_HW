// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package HomeWork5;

import java.util.HashMap;
import java.util.LinkedList;

public class task1 {
  static HashMap<String, LinkedList<Long>> phoneBook = new HashMap<>();

  public static void main(String[] args) {
    addTel("Иванов Иван", 8123456789L);
    addTel("Иванов Иван", 8987654321L);
    addTel("Петров Петр", 8923456781L);
    addTel("Петров Петр", 8111222333L);
    System.out.println(phoneBook);
  }

  static void addTel(String name, Long tel) {
    LinkedList<Long> newTel = new LinkedList<Long>();
    newTel.addLast(tel);
    boolean newUser = true;
    for (String usersName : phoneBook.keySet()) {
      if (usersName == name) {
        phoneBook.get(usersName).addLast(tel);
        newUser = false;
      }
    }
    if (newUser == true) {
      phoneBook.put(name, newTel);
    }
  }
}
