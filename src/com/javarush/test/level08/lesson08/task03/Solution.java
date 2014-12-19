package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Алёхин", "Всеволод");
        map.put("Алехин", "Михаил");
        map.put("Алёхина", "Наталья");
        map.put("Алехина", "Мария");
        map.put("Вильхивская", "Екатерина");
        map.put("Шевченко", "Екатерина");
        map.put("Просяник", "Михаил");
        map.put("Дрёмов", "Владислав");
        map.put("Тен", "Алина");
        map.put("Гейтс", "Билл");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String value = pair.getValue();
            if (value.equals(name))
                count++;
        }

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int count = 0;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            if (key.equals(familiya))
                count++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(getCountTheSameFirstName(createMap(), "Екатерина"));
    }
}
