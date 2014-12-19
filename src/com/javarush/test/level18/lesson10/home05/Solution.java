package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader(readerConsole.readLine()));
        FileOutputStream fos = new FileOutputStream(readerConsole.readLine());

        String[] numbers = readerFile.readLine().split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : numbers) {
            double d = Double.parseDouble(s);
            long l = Math.round(d);
            stringBuilder.append(l).append(" ");
        }

        byte[] bytes = stringBuilder.toString().getBytes();
        fos.write(bytes);
    }
}
