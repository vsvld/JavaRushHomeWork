package com.javarush.test.level03.lesson06.task03;

/* Семь цветов радуги
Выведи на экран текст: семь цветов радуги.
В каждой строке должно быть по три цвета, в последней - один.
Цвета разделяй пробелом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s1 = "красный";
        String s2 = "оранжевый";
        String s3 = "желтый";
        String s4 = "зеленый";
        String s5 = "голубой";
        String s6 = "синий";
        String s7 = "фиолетовый";

        System.out.println(s1 + " " + s2 + " " + s3);
        System.out.println(s4 + " " + s5 + " " + s6);
        System.out.println(s7);
    }
}