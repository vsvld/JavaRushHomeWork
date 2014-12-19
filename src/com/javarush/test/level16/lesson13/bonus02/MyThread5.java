package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod Alyokhin
 * Date: 18.04.14
 * Time: 11:33
 */
public class MyThread5 extends Thread
{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String s;
    int sum;

    @Override
    public void run()
    {
        try
        {
            while (!(s = reader.readLine()).equals("N"))
                sum += Integer.parseInt(s);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
