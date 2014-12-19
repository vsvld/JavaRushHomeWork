package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 11:33
 */
public class MyThread3 extends Thread
{
    @Override
    public void run()
    {
        try
        {
            while (!isInterrupted()) {
                System.out.println("Ура");
                sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
