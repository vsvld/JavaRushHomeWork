package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readerFile = new BufferedReader(new FileReader(readerConsole.readLine()));
             FileWriter fw = new FileWriter(readerConsole.readLine())) {

            while (readerFile.ready()) {
                String str = readerFile.readLine();
                fw.write(str.replaceAll("\\p{Punct}", "") + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
