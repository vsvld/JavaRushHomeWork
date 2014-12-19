package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 12:32
 */
public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        for (Thread thread : Solution.threads) thread.start();
        Thread.sleep(10_000);
        for (Thread thread : Solution.threads) thread.interrupt();
    }
}
