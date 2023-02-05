// Пусть дан список сотрудников:
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

package HomeWork5;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class task2 {
  public static void main(String[] args) {
    HashMap<String, String> studentsMap = new HashMap<>();

    String fileName = "HomeWork5\\students.txt";
    try {
      Scanner sc = new Scanner(new File(fileName));
      while (sc.hasNextLine()) {
        String[] name = sc.nextLine().split(" ");
        studentsMap.put(name[1], name[0]);
      }
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(studentsMap);

    HashMap<String, Integer> namesMap = new HashMap<>();
    for (String curentName : studentsMap.values()) {
      int count;
      if (namesMap.get(curentName) == null) {
        count = 0;
      } else {
        count = namesMap.get(curentName);
      }
      namesMap.put(curentName, ++count);
      continue;
    }

    LinkedHashMap<String, Integer> lMap = new LinkedHashMap<>();
    int size = namesMap.size();
    for (int i = 0; i < size; i++) {
      int valueMax = 0;
      String keyMax = "";
      for (String key : namesMap.keySet()) {
        if (valueMax < namesMap.get(key)) {
          valueMax = namesMap.get(key);
          keyMax = key;
        }
      }
      lMap.put(keyMax, valueMax);
      namesMap.remove(keyMax);
    }
    for (String name : lMap.keySet()) {
      System.out.printf("%s %s\n", name, lMap.get(name));
    }
  }
}
