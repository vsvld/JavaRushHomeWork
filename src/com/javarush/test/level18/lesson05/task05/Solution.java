package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть все потоки ввода-вывода
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean lessThan1000Bytes;

        do {
            String fileName = reader.readLine();
            FileInputStream fis = new FileInputStream(fileName);
            lessThan1000Bytes = fis.available() < 1000;
            if (lessThan1000Bytes) {
                reader.close();
                fis.close();
                throw new DownloadException();
            }
        } while (!lessThan1000Bytes);
    }

    public static class DownloadException extends Exception{

    }
}
