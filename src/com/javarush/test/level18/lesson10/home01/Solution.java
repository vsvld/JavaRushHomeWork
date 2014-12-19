package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Character> chars = new ArrayList<>();

        for (int i = 65; i < 91; i++){
            chars.add((char)i);
        }

        for (int i = 97; i < 123; i++){
            chars.add((char)i);
        }

        if (args.length != 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            int i;
            int counter = 0;

            while ((i = reader.read()) != -1) {
                char c = (char) i;
                if (chars.contains(c)) counter++;
            }

            System.out.println(counter);
            reader.close();
        }
    }
}
