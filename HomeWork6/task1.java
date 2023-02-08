package HomeWork6;

import java.util.HashSet;
import java.util.Scanner;

public class task1 {
  static Scanner myScanner;

  public static void main(String[] args) {
    HashSet<Laptop> mySet = new HashSet<Laptop>();
    mySet.add(new Laptop(1, "ASUS", "Laptop 15", 1000D, "Windows", 22999D));
    mySet.add(new Laptop(2, "HONOR", "MagicBook 15", 512D, "Windows", 41999D));
    mySet.add(new Laptop(3, "HUAWEI", "MateBook D 14", 256D, "Linux", 44999D));
    mySet.add(new Laptop(4, "Lenowo", "IdeaPad 3", 1000D, "Linux", 25999D));
    mySet.add(new Laptop(5, "Apple", "MacBook Air", 256D, "macOS", 71799D));

    System.out.printf(
        "Добро пожаловать в каталог ноутбуков!\nВыберите действие:\n1 - Печать всех товаров\n2 - Поиск по каталогу\n0 - Выход\n");

    myScanner = new Scanner(System.in);
    String usersKey = myScanner.nextLine();
    switch (usersKey) {
      case "1": {
        for (Laptop item : mySet) {
          item.printAll();
        }
        break;
      }
      case "2": {
        mySearch(mySet);
        break;
      }
      case "0": {
        break;
      }
      default: {
        System.out.println("Введино не корректное значение!");
      }
    }
    myScanner.close();
  }

  static void mySearch(HashSet<Laptop> mySet) {
    System.out.printf("Введите цифру, соответствующую критерию поиска:\n" +
        "1 - Бренд\n2 - Названи модели\n3 - Обьем жесткого диска(Гб)\n4 - Операционная система\n5 - Цена\n0 - Выход\n");
    String usersKey = myScanner.nextLine();
    switch (usersKey) {
      case "1": {
        System.out.print("Введите название бренда: ");
        String usersStr = myScanner.nextLine();
        System.out.printf("Ноутбуки с брендом %s:\n", usersStr);
        for (Laptop item : mySet) {
          if (usersStr.toLowerCase().equals(item.brand.toLowerCase())) {
            item.printAll();
          }
        }
        break;
      }
      case "2": {
        System.out.print("Введите название модели: ");
        String usersStr = myScanner.nextLine();
        System.out.printf("Ноутбуки модели %s:\n", usersStr);
        for (Laptop item : mySet) {
          if (usersStr.toLowerCase().equals(item.modelsName.toLowerCase())) {
            item.printAll();
          }
        }
        break;
      }
      case "3": {
        System.out.print("Введите обьем жесткого диска(Гб): ");
        String usersStr = myScanner.nextLine();
        Double usersDouble = Double.parseDouble(usersStr);
        System.out.printf("Ноутбуки у которых обьем жесткого диска равен %s:\n", usersStr);
        for (Laptop item : mySet) {
          if (usersDouble.equals(item.hardDiskSize)) {
            item.printAll();
          }
        }
        break;
      }
      case "4": {
        System.out.print("Введите операционную систему: ");
        String usersStr = myScanner.nextLine();
        System.out.printf("Ноутбуки у которых операционная система %s:\n", usersStr);
        for (Laptop item : mySet) {
          if (usersStr.toLowerCase().equals(item.OS.toLowerCase())) {
            item.printAll();
          }
        }
        break;
      }
      case "5": {
        System.out.print("Введите цену: ");
        String usersStr = myScanner.nextLine();
        Double usersDouble = Double.parseDouble(usersStr);
        System.out.printf("Ноутбуки у которых цена равна %s:\n", usersStr);
        for (Laptop item : mySet) {
          if (usersDouble.equals(item.prise)) {
            item.printAll();
          }
        }
        break;
      }
      case "0": {
        break;
      }
      default: {
        System.out.println("Введино не корректное значение!");
      }
    }
  }
}

class Laptop {
  Integer id;
  String brand;
  String modelsName;
  Double hardDiskSize;
  String OS;
  Double prise;

  Laptop(Integer id, String brand, String modelsName, Double hardDiskSize, String OS, Double prise) {
    this.id = id;
    this.brand = brand;
    this.modelsName = modelsName;
    this.hardDiskSize = hardDiskSize;
    this.OS = OS;
    this.prise = prise;
  }

  void printAll() {
    System.out
        .println(
            "id: " + id + "; Бренд: " + brand + "; Названи модели: " + modelsName + "; Обьем жесткого диска(Гб): " +
                hardDiskSize + "; Операционная система: " + OS + "; Цена: " + prise);
  }
}
