package Seminar_02;

import java.util.Random;

public class task_1 {

  public static void main(String[] args) {
    // 1 . Дана строка sql-запроса "select * from students where ".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    // Данные для фильтрации приведены ниже в виде json строки.
    // Если значение null, то параметр не должен попадать в запрос.
    // Параметры для фильтрации:
    // {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    
    Random random = new Random();
    System.out.println("\nЗ А Д А Ч А  1\n");
    System.out.print("Формирование запроса части WERE:\n");
    String[] sql = {
        "SELECT *\n",
        "FROM student \n",
        "WERE " };
    String[] req = { "name", "country", "city", "age" };
    String[] reqR = { "Ivanov", "Rassia", "Moscow", "null" };
    StringBuilder str = new StringBuilder();
    boolean fl = true;
    for (int i = 0; i < sql.length; i++) {
      str.append(sql[i]);
    }
    while (fl) {
      int w = random.nextInt(req.length);
      int t = random.nextInt(req.length);

      if (reqR[w] != "null" & req[w] != req[t]) {
        fl = false;
        str.append(req[w]);
        str.append(" AND ");
        str.append(req[t]);
      }
    }
    System.out.printf("%s\n\n", str);

  }
}
