package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Vsevolod", "Kh", 19);
        Man man2 = new Man("Mikhail", "Kh", 44);
        Woman woman1 = new Woman("Natasha", "Kh", 44);
        Woman woman2 = new Woman("Mary", "Kh", 15);

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man {
        String name, address;
        int age;

        public Man(String name, String address, int age)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        String name, address;
        int age;

        public Woman(String name, String address, int age)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return name + " " + age + " " + address;
        }
    }
}
