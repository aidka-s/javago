/**
 * Основы классов и объектов
 * @author Student
 * @version 1.0
 */
interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    public void fly() {
        System.out.println("Воробей летит");
    }
}

class Penguin {
}

public class Main {
    public static void makeFly(Flyable bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        makeFly(new Sparrow());
        // makeFly(new Penguin());  // Компиляция не пройдет - LSP соблюден
    }
}