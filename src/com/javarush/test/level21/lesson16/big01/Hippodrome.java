package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: vsvld
 * Date: 31.12.2014
 * Time: 15:20
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) horse.move();
    }

    public void print() {
        for (Horse horse : horses) horse.print();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistance = 0;
        for (Horse horse : horses)
            if (horse.getDistance() > maxDistance) winner = horse;
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome();

        Horse horse1 = new Horse("Horse 1", 3, 0);
        Horse horse2 = new Horse("Horse 2", 3, 0);
        Horse horse3 = new Horse("Horse 3", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}
