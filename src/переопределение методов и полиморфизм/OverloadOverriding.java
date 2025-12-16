public class OverloadOverriding {
    /**
     * Практика по переопределению методов и полиморфизму
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        demonstrateOverloading();
        demonstrateOverriding();
        demonstrateOverrideAnnotation();
        demonstratePolymorphism();
    }

    private static void demonstrateOverloading() {
        System.out.println("\n 1: Перегруженные методы");

        Calculator calc = new Calculator();

        System.out.println("Результат: " + calc.add(5, 3));
        System.out.println("Результат: " + calc.add(2, 4, 6));
        System.out.println("Результат: " + calc.add(2.5, 3.7));
        System.out.println("Результат: " + calc.add(1, 2, 3, 4, 5));
        System.out.println("Результат: " + calc.add("Hello, ", "World!"));
        System.out.println("Результат: " + calc.add(5, 3.5));
    }

    private static void demonstrateOverriding() {
        System.out.println("\n 2: Переопределенные методы ");

        Animals animal = new Animals("Неизвестное животное");
        Dogs dog = new Dogs("Бобик", "Овчарка");
        Cat cat = new Cat("Мурка");

        System.out.println(animal.makeSound());
        System.out.println(dog.makeSound());
        System.out.println(cat.makeSound());

        Animals animalChild = animal.getChild();
        Dogs dogChild = dog.getChild();
    }

    private static void demonstrateOverrideAnnotation() {
        System.out.println("\n 3: Аннотация @Override");

        BaseClasss base = new BaseClasss();
        DerivedClasss derived = new DerivedClasss();

        base.correctMethod();
        derived.correctMethod();
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n Дополнительно: Полиморфизм");

        Animals[] animals = {
                new Animals("Просто животное"),
                new Dogs("Рекс", "Дворняжка"),
                new Cat("Васька"),
                new Dogs("Лорд", "Бульдог")
        };

        for (Animals animal : animals) {
            System.out.println(animal.makeSound());
        }
    }
}

class Calculator {
    public int add(int a, int b) {
        System.out.println("add(int, int): " + a + " + " + b);
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("add(int, int, int): " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    public double add(double a, double b) {
        System.out.println("add(double, double): " + a + " + " + b);
        return a + b;
    }

    public int add(int... numbers) {
        System.out.print("add(int...): ");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println();
        return sum;
    }

    public String add(String a, String b) {
        System.out.println("add(String, String): \"" + a + "\" + \"" + b + "\"");
        return a + b;
    }
}

class Animals {
    protected String name;

    public Animals(String name) {
        this.name = name;
    }

    public String makeSound() {
        return name + " издает звук";
    }

    public Animals getChild() {
        return new Animals("Детеныш " + name);
    }
}

class Dogs extends Animals {
    private String breed;

    public Dogs(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return name + " (" + breed + ") лает: Гав-гав!";
    }

    @Override
    public Dogs getChild() {
        return new Dogs("Щенок " + name, breed);
    }
}

class Cat extends Animals {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + " мяукает: Мяу-мяу!";
    }
}

class BaseClasss {
    public void correctMethod() {
        System.out.println("Правильный метод в BaseClass");
    }
}

class DerivedClasss extends BaseClasss {
    @Override
    public void correctMethod() {
        System.out.println("Переопределенный метод в DerivedClass");
    }
}