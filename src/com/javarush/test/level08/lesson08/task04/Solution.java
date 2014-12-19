package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));
        map.put("Алёхин", new Date("MARCH 13 1994"));
        map.put("Вильхивская", new Date("NOVEMBER 26 1994"));
        map.put("Просяник", new Date("MAY 1 1993"));
        map.put("Дрёмов", new Date("FEBRUARY 19 1993"));
        map.put("Полевич", new Date("MAY 11 1994"));
        map.put("Solomon", new Date("AUGUST 5 1961"));
        map.put("Hozin", new Date("OCTOBER 20 1989"));
        map.put("Тен", new Date("JUNE 30 1993"));
        map.put("Литвиненко", new Date("JULY 3 1993"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();
            int month = pair.getValue().getMonth();
            if (month > 4 && month < 8) iterator.remove();
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);

        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String key = pair.getKey();
            Date value = pair.getValue();
            System.out.println(key + " - " + value.getMonth());
        }
    }
}
