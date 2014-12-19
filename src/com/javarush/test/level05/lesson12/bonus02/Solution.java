package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int minimum = a;
        int b = Integer.parseInt(reader.readLine());
        if (a < b) minimum = a;
        int c = Integer.parseInt(reader.readLine());
        if (c < minimum) minimum = c;
        int d = Integer.parseInt(reader.readLine());
        if (d < minimum) minimum = d;
        int e = Integer.parseInt(reader.readLine());
        if (e < minimum) minimum = e;

//        int minimum = min(a, b);

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

}
