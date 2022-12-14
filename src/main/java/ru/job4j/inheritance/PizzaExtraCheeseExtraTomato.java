package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private String name = " + ExtraTomato";

    public String name() {
        return super.name() + this.name;
    }
}
