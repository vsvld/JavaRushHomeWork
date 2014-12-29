package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("MAY 1 2013"));
        System.out.println(isDateOdd("MAY 2 2013"));
    }

    public static boolean isDateOdd(String date)
    {
        Date givenDate = new Date(date);
        Date start = new Date();
        start.setHours(0);
        start.setMinutes(0);
        start.setSeconds(0);
        start.setDate(0);
        start.setMonth(0);
        start.setYear(givenDate.getYear());
        long msTimeDistance = givenDate.getTime() - start.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
        int daysCount = (int) (msTimeDistance/msDay);
        return (daysCount % 2 == 0);
    }
}
