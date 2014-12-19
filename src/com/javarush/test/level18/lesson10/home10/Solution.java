package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода

c:/tmp/lion/Lion.txt.part2
c:/tmp/lion/Lion.txt.part5
c:/tmp/lion/Lion.txt.part1
c:/tmp/lion/Lion.txt.part3
c:/tmp/lion/Lion.txt.part4
end
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = null;
        String given;
        String fileName = "";
        String extension = "";
        byte[] buffer;
        Map<String, byte[]> files = new TreeMap();

        while (!(given = readerConsole.readLine()).equals("end")) {
            fileName = given;
            fis = new FileInputStream(fileName);
            buffer = new byte[fis.available()];
            fis.read(buffer);
            files.put(fileName, buffer);
        }

        String fileNameWithoutSuffix = fileName.substring(0, fileName.lastIndexOf('.'));
        File file = new File(fileNameWithoutSuffix);
        if(!file.exists()) file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        Collection<byte[]> values = files.values();

        for (byte[] bytes : values) fos.write(bytes);

        readerConsole.close();
        fis.close();
        fos.close();
    }
}