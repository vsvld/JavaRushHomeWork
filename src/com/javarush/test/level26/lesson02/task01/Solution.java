package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        int len = array.length;
        Integer[] newArray = new Integer[len];
        System.arraycopy(array, 0, newArray, 0, len);
        Arrays.sort(newArray);

        final double med = len % 2 == 0 ? (double) (newArray[len / 2] + newArray[len / 2 - 1]) / 2 : newArray[len / 2];
        System.out.println(med);

        Comparator<Integer> compareByMedian = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double result = (Math.abs(o1 - med) - Math.abs(o2 - med));
                return result == 0 ? o1 - o2 : (int) Math.round(result);
            }
        };

        Arrays.sort(newArray, compareByMedian);

        return newArray;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 5, 6, 7, 21, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
