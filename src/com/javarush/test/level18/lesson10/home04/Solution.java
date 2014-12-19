package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);

        byte[] buffer1 = new byte[fis1.available()];
        byte[] buffer2 = new byte[fis2.available()];

        fis1.read(buffer1);
        fis2.read(buffer2);

        FileOutputStream fos1 = new FileOutputStream(fileName1);

        fos1.write(buffer2);
        fos1.write(buffer1);

        fis1.close();
        fis2.close();
        fos1.close();
    }
}
