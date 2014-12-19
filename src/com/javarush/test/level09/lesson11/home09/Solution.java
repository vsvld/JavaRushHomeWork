package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String, Cat>();

        map.put("Barsik", new Cat("Barsik"));
        map.put("Dymka", new Cat("Dymka"));
        map.put("Ruslana", new Cat("Ruslana"));
        map.put("Jupiter", new Cat("Jupiter"));
        map.put("Fedor", new Cat("Fedor"));
        map.put("Mosya", new Cat("Mosya"));
        map.put("Pusya", new Cat("Pusya"));
        map.put("Kusya", new Cat("Kusya"));
        map.put("Vasya", new Cat("Vasya"));
        map.put("Fedya", new Cat("Fedya"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set = new HashSet<Cat>();

        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            Cat value = pair.getValue();
            set.add(value);
        }

        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
