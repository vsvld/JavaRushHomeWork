package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        StringBuilder result = new StringBuilder();
        char[] charArr = s.toCharArray();
        result.append(Character.toUpperCase(charArr[0]));

        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] != ' ' && charArr[i-1] == ' ') {
                result.append(Character.toUpperCase(charArr[i]));
                continue;
            }
            result.append(charArr[i]);
        }

//        String[] strArr = s.split(" ");
//
//        for (String str : strArr)
//        {
//            char first = Character.toUpperCase(str.charAt(0));
//            result.append(first + str.substring(1) + " ");
//        }

            System.out.println(result);
    }


}
