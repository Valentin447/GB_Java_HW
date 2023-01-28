// Задание 1.

// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.

// Входная строка:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Выходная строка:
// select * from students where name = "Ivanov" and country = "Russia" and city = "Moscow"

public class task1 {
  public static void main(String[] args) {
    String strDir = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
    String str = strDir.replace("{", "").replace("}", "")
        .replace("\"", "");
    StringBuilder finalStr = new StringBuilder();
    finalStr.append("select * from students where ");
    String[] newStr = str.split(",");

    for (int i = 0; i < newStr.length; i++) {
      String[] string3 = newStr[i].split(":");
      if (!"null".equals(string3[1].trim())) {
        finalStr.append(string3[0] + " = ");
        finalStr.append("\"" + string3[1] + "\"");
        if (i < newStr.length - 2) {
          finalStr.append(" and ");
        }
      }
    }
    System.out.print(finalStr);
  }
}
