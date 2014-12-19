package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        boolean sex;
        int height;
        int weight;
        int age;
        String hairColor;
        String eyesColor;

        public Human(boolean sex)
        {
            this.sex = sex;
        }

        public Human(boolean sex, int height, int weight)
        {
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }

        public Human(boolean sex, int age)
        {
            this.sex = sex;
            this.age = age;
        }

        public Human(boolean sex, int height, int weight, int age)
        {
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.age = age;
        }

        public Human(int height, int weight, int age)
        {
            this.height = height;
            this.weight = weight;
            this.age = age;
        }

        public Human(String hairColor, String eyesColor)
        {
            this.hairColor = hairColor;
            this.eyesColor = eyesColor;
        }

        public Human(boolean sex, int height, int weight, int age, String hairColor, String eyesColor)
        {
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.age = age;
            this.hairColor = hairColor;
            this.eyesColor = eyesColor;
        }

        public Human(boolean sex, String hairColor, String eyesColor)
        {
            this.sex = sex;
            this.hairColor = hairColor;
            this.eyesColor = eyesColor;
        }

        public Human(int height, int weight, int age, String hairColor, String eyesColor)
        {
            this.height = height;
            this.weight = weight;
            this.age = age;
            this.hairColor = hairColor;
            this.eyesColor = eyesColor;
        }

        public Human(String eyesColor)
        {
            this.eyesColor = eyesColor;
        }
    }
}
