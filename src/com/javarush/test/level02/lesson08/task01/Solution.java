package com.javarush.test.level02.lesson08.task01;

/* Минимум двух чисел
Написать функцию, которая возвращает минимум из двух чисел.
*/
public class Solution
{
    public static int min(int a, int b)
    {
        int m;
        if (a < b) m = a;
        else m = b;
        return m;
    }
}