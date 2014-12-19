package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 19.03.14
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class BelarusianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - Belarus. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 2;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
