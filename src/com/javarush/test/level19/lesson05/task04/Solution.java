package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readerFile = new BufferedReader(new FileReader(readerConsole.readLine()));
             FileWriter fw = new FileWriter(readerConsole.readLine())) {

            while (readerFile.ready()) {
                String str = readerFile.readLine();
                fw.write(str.replace('.', '!') + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
