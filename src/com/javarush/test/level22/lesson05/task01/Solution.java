package com.javarush.test.level22.lesson05.task01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();

        String str;
        int count = 0;
        int begin = 0;
        int end = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                count++;
                if (count == 1) begin = i + 1;
                else if (count == 5) end = i;
                else if (count == 4 && (string.charAt(i) == '\n' || string.charAt(i) == '\r')) end = i;
            }
        }

        if (count < 4) throw new TooShortStringException();
        else if (count == 4 && end == 0) str = string.substring(begin);
        else {
            try {
                str = string.substring(begin, end);
            } catch (Exception e) {
                throw new TooShortStringException();
            }
        }

        return str;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения "));
    }
}
