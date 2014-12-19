package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 19.03.14
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public abstract class Hen
{
    abstract int getCountOfEggsPerMonth();

    String getDescription()
    {
        return "Я курица.";
    }
}
