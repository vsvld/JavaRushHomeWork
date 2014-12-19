package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран надпись: таблицу умножения 10 на 10:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        String s4 = "";
        String s5 = "";
        String s6 = "";
        String s7 = "";
        String s8 = "";
        String s9 = "";
        String s10 = "";

        for (int i = 1; i < 11; i++) {
            s1 += i + " ";
            s2 += i*2 + " ";
            s3 += i*3 + " ";
            s4 += i*4 + " ";
            s5 += i*5 + " ";
            s6 += i*6 + " ";
            s7 += i*7 + " ";
            s8 += i*8 + " ";
            s9 += i*9 + " ";
            s10 += i*10 + " ";
        }

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        System.out.println(s9);
        System.out.println(s10);
    }
}