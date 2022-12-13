package ru.job4j.oop;

public class Electrocar {

    private int id = 1;
    private static int cl = 2;

    public class Engine {
        public void on() {
            System.out.println("Endgine is starting..." + id);
        }
    }

    public static class CarBattary {
        private int z = 0;

        public void cardge() {
            System.out.println("Battary is charging..." + cl + z);
        }
    }

    public void start() {
        int d = id;

        class Gaz {
            private void push() {
                System.out.println("Pushing..." + id + cl + d);
            }
        }

        Gaz gaz = new Gaz();
        gaz.push();

        Engine engine = new Engine();
        engine.on();
        CarBattary battary = new CarBattary();
        battary.cardge();
    }
}

class Test {
    public static void main(String[] args) {
        Electrocar electrocar = new Electrocar();
        Electrocar.Engine engine = electrocar.new Engine();
        Electrocar.CarBattary battery = new Electrocar.CarBattary();
        electrocar.start();
    }

}