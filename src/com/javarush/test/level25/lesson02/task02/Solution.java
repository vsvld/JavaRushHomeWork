package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>(4);

            try {
                for (String s : loadWheelNamesFromDB()) {
                    if (s == null) throw new IllegalArgumentException();
                    if (!wheels.contains(Wheel.valueOf(s))) wheels.add(Wheel.valueOf(s));
                    else throw new IllegalArgumentException();
                }
                if (wheels.size() != 4) throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        System.out.println(new Car().wheels);
    }
}
