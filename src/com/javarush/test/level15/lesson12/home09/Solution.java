package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        List<String> objValues = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            String s = reader.readLine();

            s = s.substring(s.indexOf('?') + 1);
            if (s.contains("&")) {
                String[] parts = s.split("&");
                for (String part : parts)
                {
                    if (part.contains("obj=") && part.indexOf("obj=") == 0)
                        objValues.add(part.substring(part.indexOf('=') + 1));
                    System.out.print(deleteEqualSignAndAfter(part) + " ");
                }
            }
            else
            {
                if (s.contains("obj=") && s.indexOf("obj=") == 0)
                    objValues.add(s.substring(s.indexOf('=') + 1));
                System.out.print(deleteEqualSignAndAfter(s));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (! objValues.isEmpty()) {
            System.out.println();
            for (String objVal : objValues)
            {
                if (isNumeric(objVal))
                    alert(Double.parseDouble(objVal));
                else
                    alert(objVal);
            }
        }
    }

    public static String deleteEqualSignAndAfter(String string) {
        if (string.contains("=")) {
            string = string.substring(0, string.indexOf('='));
        }
        return string;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
