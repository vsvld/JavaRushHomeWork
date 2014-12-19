package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

c:/tmp/id.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader(readerConsole.readLine()));

        String line = "";
        String id = args[0];
        boolean idNotFound = true;

        while ((line = readerFile.readLine()) != null && idNotFound) {
            String strID = "";

            for (int i = 0; i < line.length(); i++)
                if (line.charAt(i) == ' ') {
                    strID = line.substring(0, i);
                    break;
                }

            if (strID.equals(id)) {
                idNotFound = false;
                System.out.println(line);
            }
        }
    }
}
