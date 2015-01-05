package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();

        String str;
        int count = 0;
        int begin = 0;
        int end = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '\t') {
                count++;

                if (count == 1)
                    begin = i + 1;
                else if (count == 2) {
                    end = i;
                    break;
                }
            }
        }

        if (count < 2) throw new TooShortStringException();
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
}
