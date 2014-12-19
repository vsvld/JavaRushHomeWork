package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 11:33
 */
public class MyThread2 extends Thread
{
    @Override
    public void run()
    {
        try
        {
            join();
        }
        catch (InterruptedException e)
        {
            System.out.println("InterruptedException");
        }
    }
}
