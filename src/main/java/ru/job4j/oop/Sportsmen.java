package ru.job4j.oop;

public abstract class Sportsmen {
    private int age = 34;
    private static int heght = 177;

    public void run() {
        System.out.println("running...");
    }

    public static void fly() {
        System.out.println("Cant fly...");
    }

    public abstract void swim();
}
