package com.javarush.test.level14.lesson06.home01;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 19.03.14
 * Time: 11:49
 * To change this template use File | Settings | File Templates.
 */
public class UkrainianHen extends Hen
{
    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - Ukraine. Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

    @Override
    int getCountOfEggsPerMonth()
    {
        return 4;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
