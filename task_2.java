package Seminar_02;

import java.util.Random;
import java.io.IOException;
import java.util.logging.*;

public class task_2 {

  public static void fillarray(int[] array) {
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(10, 99);
    }
  }

  public static void printArray(int[] ar) {
    for (int i = 0; i < ar.length; i++) {
      System.out.printf("%d ", ar[i]);
    }
  }

  public static String recArray_ToStr(int[] ar) {
    StringBuilder str = new StringBuilder();
    str.append("[ ");
    for (int i = 0; i < ar.length; i++) {
      str.append(Integer.toString(ar[i]));
      str.append(" ");
    }
    str.append("]");
    return str.toString();
  }

  public static void sortingBubble(int[] array) {
    int len = array.length;
    int temp = 0;
    for (int i = 0; i < len - 1; i++) {
      for (int j = i; j < len; j++) {
        if (array[i] > array[j]) {
          temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    // 2 . Реализуйте алгоритм сортировки пузырьком числового массива,
    // результат после каждой итерации запишите в лог-файл.
    System.out.println("\nЗ А Д А Ч А  2\n");
    int len = 17;
    int[] ar = new int[len];

    Logger logger = Logger.getLogger(task_2.class.getName());
    // ConsoleHandler ch = new ConsoleHandler(); // все ошибки в терминале
    FileHandler fh = new FileHandler("log_2.txt");
    // logger.addHandler(ch);
    logger.addHandler(fh);

    SimpleFormatter sFormat = new SimpleFormatter();
    // XMLFormatter xml = new XMLFormatter();
    fh.setFormatter(sFormat);
    // fh.setFormatter(xml);

    logger.setLevel(Level.CONFIG);
    logger.setUseParentHandlers(false);

    fillarray(ar);

    System.out.print("Массив заполнен - - ----> ");
    printArray(ar);

    String res = recArray_ToStr(ar);
    int temp = 0;

    logger.info("\tСортировка массива: " + res);
    for (int i = 0; i < len - 1; i++) {
      res = recArray_ToStr(ar);
      logger.info("Работа с числом'" + ar[i] + "'\tмассив: " + res);
      for (int j = i; j < len; j++) {
        if (ar[i] > ar[j]) {
          res = recArray_ToStr(ar);
          logger.info("Cравнения чисел " + ar[i] + " > " + ar[j] + "\tмассив: " + res);
          temp = ar[i];
          ar[i] = ar[j];
          ar[j] = temp;
        }
      }
    }
    res = recArray_ToStr(ar);
    logger.info("\tОтсортированный массив: " + res);
    System.out.print("\nОтсортированный массив -> ");
    printArray(ar);
    System.out.print("\n\nЭтапы сортировки записаны в журнал 'log.txt'");

    System.out.print("\n\n");

  }
}
