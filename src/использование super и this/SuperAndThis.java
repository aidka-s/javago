// Родительский класс
class Transport {
    String name = "Transport";
    int speed = 60;

    public Transport() {
        System.out.println("Создан транспорт");
    }

    public Transport(String name) {
        this.name = name;
        System.out.println("Создан " + name);
    }

    public void move() {
        System.out.println("Транспорт движется");
    }
}

// Дочерний класс
class Auto extends Transport {
    String name = "Автомобиль";
    int wheels = 4;

    public Auto() {
        super(); // Вызываем конструктор родителя
        System.out.println("Создан автомобиль");
    }

    public Auto(String name, int wheels) {
        super(name); // Конструктор с параметром
        this.wheels = wheels;
        System.out.println("Колес: " + wheels);
    }

    @Override
    public void move() {
        System.out.println("Автомобиль едет");
    }

    public void showInfo() {
        System.out.println("Родительское имя: " + super.name);
        System.out.println("Текущее имя: " + this.name);
        super.move(); // Вызов метода родителя
        System.out.println("Колес: " + wheels);
    }
}

// Внучатый класс
class RacingCar extends Auto {
    boolean turbo = false;

    public RacingCar(String name, int wheels, boolean turbo) {
        super(name, wheels);
        this.turbo = turbo;
        System.out.println("Турбо: " + turbo);
    }

    @Override
    public void move() {
        super.move(); // Вызываем метод родителя
        if (turbo) {
            System.out.println("Включен турбо-режим!");
        }
    }
}

// Простое наследование
class A {
    int number = 5;

    void print() {
        System.out.println("A: " + number);
    }
}

class B extends A {
    // Ничего не переопределяем
}

class C extends B {
    void show() {
        // super обращается к A, так как B не переопределяет
        System.out.println("Число из A: " + super.number);
        super.print();
    }
}

// Использование this() в конструкторах
class Settings {
    int width;
    int height;

    // Конструктор по умолчанию
    public Settings() {
        this(0, 0); // Вызов другого конструктора
    }

    // Конструктор с одним параметром
    public Settings(int width) {
        this(width, 0);
    }

    // Основной конструктор
    public Settings(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void display() {
        System.out.println("Настройки: " + width + "x" + height);
    }
}

// Главный класс
public class SuperAndThis {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация super ===\n");

        System.out.println("1. Обычный автомобиль:");
        Auto car = new Auto("Toyota", 4);
        car.showInfo();

        System.out.println("\n2. Гоночный автомобиль:");
        RacingCar raceCar = new RacingCar("Ferrari", 4, true);
        raceCar.move();

        System.out.println("\n3. Цепочка наследования:");
        C obj = new C();
        obj.show();

        System.out.println("\n4. Использование this():");
        Settings s1 = new Settings();
        Settings s2 = new Settings(100);
        Settings s3 = new Settings(200, 300);

        s1.display();
        s2.display();
        s3.display();

        System.out.println("\n5. Простой пример:");

        class Parent {
            String text = "Родитель";

            void say() {
                System.out.println("Привет от родителя");
            }
        }

        class Child extends Parent {
            String text = "Ребенок";

            void say() {
                System.out.println("Привет от ребенка");
                super.say(); // Вызов метода родителя
            }

            void showTexts() {
                System.out.println("Родитель: " + super.text);
                System.out.println("Ребенок: " + this.text);
            }
        }

        Child child = new Child();
        child.say();
        child.showTexts();
    }
}