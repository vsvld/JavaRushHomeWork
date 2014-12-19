package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos2 = new FileOutputStream(fileName2);
        FileOutputStream fos3 = new FileOutputStream(fileName3);

        if (fis.available() > 0) {
            int bytesFile1 = fis.available();
            int count = bytesFile1 / 2;
            byte[] buffer2 = new byte[count];
            byte[] buffer1 = new byte[bytesFile1 - count];

            fis.read(buffer1);
            fis.read(buffer2);

            fos2.write(buffer1);
            fos3.write(buffer2);
        }

        reader.close();
        fis.close();
        fos2.close();
        fos3.close();
    }
}
