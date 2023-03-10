package Seminar_02;

import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class task_4 {
  public static void main(String[] args) throws SecurityException, IOException {

    // Реализовать простой калькулятор
    // + сделать журнал

    System.out.println("\nЗ А Д А Ч А  4\n");
    System.out.println("- ------ К А Л Ь К У Л Я Т О Р ------ -");
    boolean fl = true;
    Scanner iScanner = new Scanner(System.in);

    Logger logger = Logger.getLogger(task_4.class.getName());
    // ConsoleHandler ch = new ConsoleHandler(); // все ошибки в терминале
    FileHandler fh = new FileHandler("log_4.txt");
    // logger.addHandler(ch);
    logger.addHandler(fh);

    SimpleFormatter sFormat = new SimpleFormatter();
    // XMLFormatter xml = new XMLFormatter();
    fh.setFormatter(sFormat);
    // fh.setFormatter(xml);

    logger.setLevel(Level.CONFIG);
    logger.setUseParentHandlers(false);
    
    logger.info("Запуск программы 'КАЛЬКУЛЯТОР'.");

    do {
      System.out.println("\tСложение   нажмите '1'");
      System.out.println("\tВычетание  нажмите '2'");
      System.out.println("\tУмножение  нажмите '3'");
      System.out.println("\tДеление    нажмите '4'");
      System.out.println("\tПроцент    нажмите '5'");
      System.out.print("\nВведите число -> ");
      int n = iScanner.nextInt();
      int a, b;
      float r, t;
      switch (n) {
        case 1:
          System.out.print("- Сложение -\n");
          System.out.print("Введите первое число -> ");
          a = iScanner.nextInt();
          System.out.print("Введите второе число -> ");
          b = iScanner.nextInt();
          System.out.printf("\nСложение чисел: %d + %d = %d\n\n", a, b, a + b);
          logger.info("Сложение чисел: " + a + " + " + b + " = " + (a + b));
          break;
        case 2:
          System.out.print("- Вычетание -\n");
          System.out.print("Введите первое число -> ");
          a = iScanner.nextInt();
          System.out.print("Введите второе число -> ");
          b = iScanner.nextInt();
          System.out.printf("\nВычетание чисел: %d - %d = %d\n\n", a, b, a - b);
          logger.info("Вычетание чисел: " + a + " - " + b + " = " + (a - b));
          break;
        case 3:
          System.out.print("- Умножение -\n");
          System.out.print("Введите первое число -> ");
          a = iScanner.nextInt();
          System.out.print("Введите второе число -> ");
          b = iScanner.nextInt();
          System.out.printf("\nУмножение чисел: %d * %d = %d\n\n", a, b, a * b);
          logger.info("Умножение чисел: " + a + " * " + b + " = " + (a * b));
          break;
        case 4:
          System.out.print("- Деление -\n");
          System.out.print("Введите первое число -> ");
          r = iScanner.nextFloat();
          System.out.print("Введите второе число -> ");
          t = iScanner.nextFloat();
          System.out.printf("\nДеление чисел: %.1f / %.1f = %.2f\n\n", r, t, r / t);
          logger.info("Деление чисел: " + r + " / " + t + " = " + (r / t));
          break;
        case 5:
          System.out.print("- Процент -\n");
          System.out.print("Введите число -> ");
          r = iScanner.nextFloat();
          System.out.printf("Введите процент от числа %.0f -> ", r);
          t = iScanner.nextFloat();
          System.out.printf("\nПроцент от числа: %.0f - %.0f%% = %.0f\n\n", r, t, r * (100 - t) / 100);
          logger.info("Процент от числа: " + r + " - " + t + "%" + " = " + ((100 - t) / 100));
          break;
        default:
          System.out.print("Формат ввода неверный!\n");
          break;
      }
      System.out.println("Продолжить работу программы, нажмите любую клавишу");
      System.out.print("Выход из программы, нажите 'q' -> ");
      // System.out.print("Продолжить работу программы, нажите ''");
      String d = iScanner.next();
      switch (d.toLowerCase()) {
        case "q":
          fl = false;
          break;
        default:
          fl = true;
          break;
      }
    } while (fl);
    logger.info("Завершение программы 'КАЛЬКУЛЯТОР'.");
    iScanner.close();
  }
}
