package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 3) {
            FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);

            switch (args[0]) {
                case "-e":
                    while (fis.available() > 0) {
                        fos.write(fis.read());
                        fos.write('a');
                    }
                    break;
                case "-d":
                    int count = fis.available();
                    for (int i = 0; i < count; i++) {
                        if (i % 2 != 0) fis.read();
                        else fos.write(fis.read());
                    }
                    break;
            }

            fis.close();
            fos.close();
        }
    }

}
