package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        findGCD(a, b);
    }

    static void findGCD(int a, int b)
    {
        int c;

        if (a > b)
        {
            c = a - b;
            findGCD(b, c);
        }
        else if (b > a)
        {
            c = b - a;
            findGCD(a, c);
        }
        else
        {
            System.out.println(a);
        }
    }
}
