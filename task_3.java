package Seminar_02;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class task_3 {

  public static void jsonLine(String line) {
    String st = "";
    st = line.replace("[", "");
    st = st.replace("{", "");
    st = st.replace("}", "");
    st = st.replace(",", ":");
    st = st.replace("]", "");
    st = st.replaceAll("\"", "");
    String[] data1 = { "Студент", "получил", "по предмету" };
    String[] data2 = st.split(":");
    StringBuilder data = new StringBuilder();
    int count = 0;
    for (int i = 1; i < data2.length; i += 2) {
      data.append(data1[count++]);
      data.append(" ");
      data.append(data2[i]);
      data.append(" ");
    }
    System.out.println(data);
  }

  public static void main(String[] args) {

    // 3* . Дана json строка (можно сохранить в файл и читать из файла)

    // [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

    // Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
    // строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

    // Пример вывода:
    // Студент Иванов получил 5 по предмету Математика.
    // Студент Петрова получил 4 по предмету Информатика.
    // Студент Краснов получил 5 по предмету Физика.

    // FileInputStream fis = new FileInputStream("task_3.txt");
    // String data = IOUtils.toString(fis, "UTF-8");
    String line_1 = "";
    String line_2 = "";
    String line_3 = "";

    System.out.println("\nЗ А Д А Ч А  3\n");
    try {
      File file = new File("to_task_3.txt");
      BufferedReader bufReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));
      line_1 = bufReader.readLine();
      line_2 = bufReader.readLine();
      line_3 = bufReader.readLine();
      bufReader.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.out.println("Информация с файла:\n");
      System.out.println(line_1);
      System.out.println(line_2);
      System.out.println(line_3);
      System.out.println();
    }
    System.out.println("Результат:\n");
    jsonLine(line_1);
    jsonLine(line_2);
    jsonLine(line_3);
    System.out.println("\n");


  }
}
