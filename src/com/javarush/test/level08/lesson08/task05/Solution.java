package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        Iterator<Map.Entry<String, String>> iterator = copy.entrySet().iterator();
        while (iterator.hasNext()){
            String s = iterator.next().getValue();
            iterator.remove();
            for (Map.Entry<String, String> pair: copy.entrySet())
            {
                if (s.equals(pair.getValue()))
                    removeItemFromMapByValue(map, s);
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
