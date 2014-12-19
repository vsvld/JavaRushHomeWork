package com.javarush.test.level14.lesson08.home02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 21.03.14
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public abstract class Drink
{
    public void taste()
    {
        System.out.println("Вкусно");
    }

    public abstract String getHolidayName();
}
