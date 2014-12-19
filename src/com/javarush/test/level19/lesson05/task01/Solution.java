package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(readerConsole.readLine());
             FileOutputStream fos = new FileOutputStream(readerConsole.readLine())) {

            int count = fis.available();
            byte[] bytes = new byte[count];
            fis.read(bytes);

            for (int i = 1; i <= count; i++) {
                if (i % 2 == 0) fos.write(bytes[i - 1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
