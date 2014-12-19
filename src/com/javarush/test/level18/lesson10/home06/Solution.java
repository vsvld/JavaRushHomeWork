package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        TreeMap<Character, Integer> bytes = new TreeMap<>();

        while (fileInputStream.available() > 0) {
            char symbol = (char) fileInputStream.read();
            if (bytes.containsKey(symbol)) bytes.put(symbol, bytes.get(symbol) + 1);
            else bytes.put(symbol, 1);
        }

        for (Map.Entry<Character, Integer> pair : bytes.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        fileInputStream.close();
    }
}
