package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 14.04.14
 * Time: 13:46
 * To change this template use File | Settings | File Templates.
 */
public class LatteMaker extends DrinkMaker
{
    @Override
    void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    @Override
    void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    @Override
    void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }
}
