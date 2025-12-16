/**
 * Демонстрация перегрузки (overloading) и переопределения (overriding) методов.
 */
public class MethodsDemo {

    public static void main(String[] args) {
        demonstrateMethodOverloading();
        demonstrateMethodOverriding();
        demonstrateConstructorOverloading();
    }

    /**
     * Демонстрация перегрузки методов (overloading)
     */
    private static void demonstrateMethodOverloading() {
        System.out.println("=== Перегрузка методов (Overloading) ===");

        OverloadExample example = new OverloadExample();

        // Перегрузка работает по типам и количеству параметров
        example.print(42);           // int
        example.print(3.14);         // double
        example.print("Hello");      // String
        example.print(5, 7);         // два int
    }

    /**
     * Демонстрация переопределения методов (overriding)
     */
    private static void demonstrateMethodOverriding() {
        System.out.println("\n=== Переопределение методов (Overriding) ===");

        Animal animal = new Dog();
        animal.makeSound();       // Dog sound (переопределение!)
    }

    /**
     * Демонстрация перегрузки конструкторов
     */
    private static void demonstrateConstructorOverloading() {
        System.out.println("\n=== Перегрузка конструкторов ===");
        // Конструкторы тоже перегружаются
        new Box(10);
        new Box(20, 30);
    }
}

/**
 * Класс для демонстрации перегрузки методов
 */
class OverloadExample {

    // ПЕРЕГРУЗКА (overloading) - разные параметры в одном классе
    public void print(int num) {
        System.out.println("int: " + num);
    }

    public void print(double num) {
        System.out.println("double: " + num);
    }

    public void print(String text) {
        System.out.println("String: " + text);
    }

    public void print(int a, int b) {
        System.out.println("int x int: " + (a + b));
    }
}

/**
 * Базовый класс для демонстрации переопределения методов
 */
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

/**
 * Производный класс с переопределением метода
 */
class Dog extends Animal {
    @Override  // Аннотация переопределения
    public void makeSound() {
        System.out.println("Dog: Woof!");
    }
}

/**
 * Класс для демонстрации перегрузки конструкторов
 */
class Box {
    int width, height;

    public Box(int size) {
        width = height = size;
        System.out.println("Квадрат: " + size);
    }

    public Box(int w, int h) {
        width = w;
        height = h;
        System.out.println("Прямоугольник: " + w + "x" + h);
    }
}