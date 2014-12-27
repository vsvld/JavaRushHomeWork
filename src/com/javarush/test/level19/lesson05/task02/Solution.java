package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.

c:/tmp/world.txt
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader (readerConsole.readLine()))) {

            int count = 0;

            while (readerFile.ready()) {
                Pattern pattern = Pattern.compile("\\b[wW]orld\\b");
                Matcher matcher = pattern.matcher(readerFile.readLine());
                while (matcher.find()) count++;
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
