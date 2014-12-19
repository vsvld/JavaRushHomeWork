package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        HashMap<Integer, Integer> bytes = new HashMap<>();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (bytes.containsKey(data)) bytes.put(data, bytes.get(data) + 1);
            else bytes.put(data, 1);
        }

        Collection<Integer> values = bytes.values();
        int minFreq = Byte.MAX_VALUE;

        for (int i : values)
            if (minFreq > i) minFreq = i;

        for (Map.Entry<Integer, Integer> pair : bytes.entrySet())
            if (pair.getValue() == minFreq)
                System.out.print(pair.getKey() + " ");

        reader.close();
        fileInputStream.close();
    }
}
