package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        // сортируем цифры с помощью selection sort
        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i])){
                int max = i;
                for (int j = i+1; j < array.length; j++)
                    if (isNumber(array[j]) && Integer.parseInt(array[j]) > Integer.parseInt(array[max]))
                        max = j;
                String swap = array[i];
                array[i] = array[max];
                array[max] = swap;
            }
        }

        // сортируем строки с помощью selection sort
        for (int i = 0; i < array.length; i++)
        {
            if (!(isNumber(array[i]))){
                int min = i;
                for (int j = i+1; j < array.length; j++)
                    if (!(isNumber(array[j])) && isGreaterThen(array[min], array[j]))
                        min = j;
                String swap = array[i];
                array[i] = array[min];
                array[min] = swap;
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
