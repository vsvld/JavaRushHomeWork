package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. выбросить исключение CorruptedDataException
4.2. очистить allLines от данных
Сигнатуру метода main не менять
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException
    {

        String firstFileName, secondFileName, s;
        BufferedReader reader;

        try
        {
            reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

            reader = new BufferedReader(new FileReader(firstFileName));
            while ((s = reader.readLine()) != null) {
                allLines.add(s);
            }

            reader = new BufferedReader(new FileReader(secondFileName));
            while ((s = reader.readLine()) != null) {
                forRemoveLines.add(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        new Solution().joinData();
    }

    public void joinData() throws CorruptedDataException
    {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
