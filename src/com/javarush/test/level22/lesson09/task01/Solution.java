package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"

c:/tmp/220901.txt
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(consoleReader.readLine())) {

            Scanner scanner = new Scanner(fileReader);
            ArrayList<String> words = new ArrayList<>();
            while (scanner.hasNext()) words.add(scanner.next());

            for (int i = 0; i < words.size(); i++) {
                String wordReversed = new StringBuilder(words.get(i)).reverse().toString();
                for (int j = i + 1; j < words.size(); j++) {
                    if (wordReversed.equals(words.get(j))) {
                        Pair pair = new Pair();
                        pair.first = words.get(i);
                        pair.second = words.get(j);
                        result.add(pair);
                        break;
                    }
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
