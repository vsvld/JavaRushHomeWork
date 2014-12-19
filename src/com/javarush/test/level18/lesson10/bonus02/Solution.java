package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

c:/tmp/crud18.txt
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static boolean isNumeric(String str)
    {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerConsole.readLine();
        String productName, line;
        float price;
        int id, quantity, idFound;
        int idMax = 0;

        try (BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
             BufferedWriter fos = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "UTF-8"))) {

            while ((line = readerFile.readLine()) != null) {
                Pattern pattern = Pattern.compile("\\d{1,8}");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    idFound = Integer.parseInt(matcher.group());
                    if (idFound > idMax) idMax = idFound;
                }
            }

            if (args[0].equals("-c")) {
                id = idMax + 1;
                StringBuilder argsLine = new StringBuilder();

                for (int i = 1; i < args.length - 2; i++)
                    argsLine.append(args[i]).append(" ");

                productName = argsLine.toString().trim();
                price = Float.parseFloat(args[args.length - 2]);
                quantity = Integer.parseInt(args[args.length - 1]);
                String str = String.format("\n%-8d%-30s%-8.2f%-4d", id, productName, price, quantity);
                fos.write(str);
                fos.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            readerConsole.close();
        }
    }
}
