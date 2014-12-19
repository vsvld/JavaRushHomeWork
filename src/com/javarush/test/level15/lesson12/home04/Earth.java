package com.javarush.test.level15.lesson12.home04;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 13.04.14
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public class Earth implements Planet
{
    private static Earth instance;

    private Earth()
    {
    }

    public static Earth getInstance()
    {
        if (instance == null)
        {
            instance = new Earth();
        }
        return instance;
    }
}
