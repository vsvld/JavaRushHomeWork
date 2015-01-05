package com.javarush.test.level22.lesson13.task01;

import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        String[] array = new String[stringTokenizer.countTokens()];
        for (int i = 0; i < array.length; i++) array[i] = stringTokenizer.nextToken();
        return array;
    }
}
