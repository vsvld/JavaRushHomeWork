package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Использовать функцию из задачи 1.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        int min1, min2;
        min1 = min(a, b);
        min2 = min(c, d);
        return min(min1, min2);
    }

    public static int min(int a, int b)
    {
        int m;
        if (a < b) m = a;
        else m = b;
        return m;
    }
}