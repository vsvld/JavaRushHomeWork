package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 11:32
 */
public class MyThread1 extends Thread
{
    @Override
    public void run()
    {
        while (!isInterrupted()) {}
    }
}
