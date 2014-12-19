package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        String fileName = "";
        LinkedHashMap<String, String> fileMap = new LinkedHashMap<>();
        String line;

        try (BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = readerConsole.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader readerFile = new BufferedReader(new FileReader(fileName))) {

            while ((line = readerFile.readLine()) != null) {
                String id = line.substring(0, 8).trim();
                String rest = line.substring(8);
                fileMap.put(id, rest);
            }

            String id = args[1];

            switch (args[0]) {

                case "-u":
                    float price = Float.parseFloat(args[args.length - 2]);
                    int quantity = Integer.parseInt(args[args.length - 1]);

                    StringBuilder argsLine = new StringBuilder();
                    for (int i = 2; i < args.length - 2; i++)
                        argsLine.append(args[i]).append(" ");
                    String productName = argsLine.toString().trim();

                    String str = String.format("%-30s%-8.2f%-4d", productName, price, quantity);
                    fileMap.put(id, str);

                    break;

                case "-d":
                    fileMap.remove(id);
                    break;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {

            for (Map.Entry<String, String> pair : fileMap.entrySet()) {
                String str = String.format("%-8s%s", pair.getKey(), pair.getValue());
                writer.write(str);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
