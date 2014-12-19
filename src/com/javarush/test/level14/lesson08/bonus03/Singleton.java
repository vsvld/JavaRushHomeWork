package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 09.04.14
 * Time: 6:51
 * To change this template use File | Settings | File Templates.
 */
public class Singleton
{
    private static Singleton instance;
    private Singleton()
    {
    }

    static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
