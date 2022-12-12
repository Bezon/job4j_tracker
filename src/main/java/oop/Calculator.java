package oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return multiply(d) + minus(d) + divide(d) + sum(d);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(5));
        System.out.println(calculator.multiply(4));
        System.out.println(minus(3));
        System.out.println(calculator.sumAllOperation(2));
    }
}
