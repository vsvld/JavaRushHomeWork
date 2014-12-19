package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0, sum = 0;
        String sm = "сумма";

        while (true) {
            String s = reader.readLine();
            if (s.equals(sm)) break;
            n = Integer.parseInt(s);
            sum += n;
        }
        System.out.println(sum);
    }
}
