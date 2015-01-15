package com.javarush.test.level25.lesson09.task03;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> list = new ArrayList<>();
        list.add(e);

        for (int i = 0; ; i++) {
            Throwable thr = list.get(i);
            if (thr.getCause() != null) list.add(thr.getCause());
            else break;
        }

        Collections.reverse(list);
        for (Throwable thr : list) System.out.println(thr.getClass().getName() + ": " + thr.getMessage());
    }

    public static void main(String[] args) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler(new Solution());
        throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}
