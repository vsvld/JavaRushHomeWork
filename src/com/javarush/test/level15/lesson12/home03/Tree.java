package com.javarush.test.level15.lesson12.home03;

public class Tree {
    public static int globalNumber;
    public int number;

    public Tree() {
        this.number = ++globalNumber;
    }

    public void info(Object s) {
        System.out.println(String.format("Дерево № %d , метод Object, параметр %s", number, s.getClass().getSimpleName()));
    }

    public void info(Number n) {
        System.out.println(String.format("Дерево № %d , метод Number, параметр %s", number, n.getClass().getSimpleName()));
    }

    public void info(String string) {
        System.out.println(String.format("Дерево № %d , метод String, параметр %s", number, string.getClass().getSimpleName()));
    }
}
