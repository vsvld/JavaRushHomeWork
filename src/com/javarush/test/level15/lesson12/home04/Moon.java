package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 13.04.14
 * Time: 16:12
 * To change this template use File | Settings | File Templates.
 */
public class Moon implements Planet
{
    private static Moon instance;

    private Moon()
    {
    }

    public static Moon getInstance()
    {
        if (instance == null)
        {
            instance = new Moon();
        }
        return instance;
    }
}
