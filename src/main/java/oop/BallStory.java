package oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Fox fox = new Fox();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        wolf.tryEat(ball);
        hare.tryEat(ball);
        fox.tryEat(ball);
    }
}
