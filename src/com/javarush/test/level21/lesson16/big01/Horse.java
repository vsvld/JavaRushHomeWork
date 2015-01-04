package com.javarush.test.level21.lesson16.big01;

/**
 * Created with IntelliJ IDEA.
 * User: vsvld
 * Date: 31.12.2014
 * Time: 15:20
 */
public class Horse {
    private String name;
    private double speed, distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {
        for (int i = 0; i < distance; i++) System.out.print('.');
        System.out.println(name);
    }
}
