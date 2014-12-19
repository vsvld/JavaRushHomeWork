package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки

c:/tmp/111.txt
c:/tmp/222.txt
c:/tmp/333.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileOutputStream fos1 = new FileOutputStream(fileName1);
        FileInputStream fis2 = new FileInputStream(fileName2);
        FileInputStream fis3 = new FileInputStream(fileName3);

        if (fis2.available() > 0) {
            byte[] buffer2 = new byte[fis2.available()];
            fis2.read(buffer2);
            fos1.write(buffer2);
        }

        if (fis3.available() > 0) {
            byte[] buffer3 = new byte[fis3.available()];
            fis3.read(buffer3);
            fos1.write(buffer3);
        }

        fos1.close();
        fis2.close();
        fis3.close();
    }
}
