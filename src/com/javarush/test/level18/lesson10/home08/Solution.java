package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            else new ReadThread(fileName).run();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            super();
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {

            try (FileInputStream fis = new FileInputStream(fileName)) {

                HashMap<Integer, Integer> bytes = new HashMap<>();

                while (fis.available() > 0) {
                    int data = fis.read();
                    if (bytes.containsKey(data)) bytes.put(data, bytes.get(data) + 1);
                    else bytes.put(data, 1);
                }

                Collection<Integer> values = bytes.values();
                int maxFreq = 0;

                for (int i : values)
                    if (maxFreq < i) maxFreq = i;

                for (Map.Entry<Integer, Integer> pair : bytes.entrySet())
                    if (pair.getValue() == maxFreq)
                        resultMap.put(fileName, pair.getKey());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
