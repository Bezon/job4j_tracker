package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private String name = " + ExtraCheese";

    public String name() {
        return super.name() + this.name;
    }
}
