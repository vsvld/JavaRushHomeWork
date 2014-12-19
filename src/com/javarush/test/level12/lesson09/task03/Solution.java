package com.javarush.test.level12.lesson09.task03;

/* Fly, Run, Swim для классов Dog, Fish, Bird, Airplane
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Dog(собака), Fish(рыба), Bird(птица), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Run
    {
        public void run();
    }

    public interface Swim
    {
        public void swim();
    }

    public class Dog implements Run, Swim
    {
        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void swim()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Fish implements Swim
    {
        @Override
        public void swim()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Bird implements Fly, Swim, Run
    {
        @Override
        public void fly()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void swim()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Airplane implements Fly, Run
    {
        @Override
        public void fly()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void run()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
