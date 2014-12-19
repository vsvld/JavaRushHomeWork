package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 11:33
 */
public class MyThread4 extends Thread implements Message
{
    @Override
    public void run()
    {
        while (!isInterrupted());
    }

    @Override
    public void showWarning()
    {
        interrupt();
        try
        {
            join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
