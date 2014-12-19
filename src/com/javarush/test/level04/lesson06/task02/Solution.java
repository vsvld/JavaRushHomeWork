package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];

        String s1 = reader.readLine();
        arr[0] = Integer.parseInt(s1);
        String s2 = reader.readLine();
        arr[1] = Integer.parseInt(s2);
        String s3 = reader.readLine();
        arr[2] = Integer.parseInt(s3);
        String s4 = reader.readLine();
        arr[3] = Integer.parseInt(s4);

        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > max) max = x;
        }

        System.out.println(max);
    }
}
