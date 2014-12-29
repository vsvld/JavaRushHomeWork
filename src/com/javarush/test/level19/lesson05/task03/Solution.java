package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1

C:/tmp/195from.txt
C:/tmp/195to.txt
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(consoleReader.readLine());
             FileWriter fileTo = new FileWriter(consoleReader.readLine())) {

            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                String str = scanner.next();
                try {
                    Double.parseDouble(str);
                    fileTo.write(str + " ");
                } catch (NumberFormatException e) {
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
