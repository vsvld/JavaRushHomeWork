package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();

        set.add("Любовь");
        set.add("Леопард");
        set.add("Лагуна");
        set.add("Лубрикант");
        set.add("Левитация");
        set.add("Легинсы");
        set.add("Лужа");
        set.add("Лава");
        set.add("Ловкость");
        set.add("Лежбище");
        set.add("Лоботомия");
        set.add("Лавры");
        set.add("Лазейка");
        set.add("Лук");
        set.add("Лак");
        set.add("Ложь");
        set.add("Лесть");
        set.add("Лира");
        set.add("Лох");
        set.add("Лепта");

        return set;
    }
}
