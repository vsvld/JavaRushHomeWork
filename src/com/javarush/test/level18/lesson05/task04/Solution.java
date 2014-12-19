package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos = new FileOutputStream(fileName2);

        if (fis.available() > 0) {
            int count = fis.available();
            byte[] buffer = new byte[count];
            fis.read(buffer);

            for (int i = 0; i < buffer.length / 2; i++) {
                byte temp = buffer[i];
                buffer[i] = buffer[buffer.length - (i + 1)];
                buffer[buffer.length - (i + 1)] = temp;
            }

            fos.write(buffer);

            reader.close();
            fis.close();
            fos.close();
        }
    }
}
