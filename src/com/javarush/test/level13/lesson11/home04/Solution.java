package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;

        try (FileWriter fw = new FileWriter(reader.readLine());)
        {
            while(true)
            {
                s = reader.readLine();
                if (s.equals("exit"))
                {
                    fw.write(s);
                    break;
                }
                s = s + "\r\n";
                fw.write(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
