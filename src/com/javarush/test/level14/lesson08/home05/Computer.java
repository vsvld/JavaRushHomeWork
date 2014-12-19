package com.javarush.test.level14.lesson08.home05;

/**
 * Created with IntelliJ IDEA.
 * User: Vsevolod
 * Date: 21.03.14
 * Time: 18:15
 * To change this template use File | Settings | File Templates.
 */
public class Computer
{
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer()
    {
        keyboard = new Keyboard();
        mouse = new Mouse();
        monitor = new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}
