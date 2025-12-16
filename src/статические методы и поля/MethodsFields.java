/**
 * Демонстрация всех способов вызова статического метода printVars().
 * @author Student
 * @version 1.0
 */
public class MethodsFields {
    public static int a = 1;
    public static int b = 99; // инициализируем для наглядности

    public static void main(String[] args) {
        demonstrateStaticMethodCalls();
        demonstrateStaticFieldModification();
    }

    /**
     * Статический метод - принадлежит классу A.
     */
    public static void printVars() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /**
     * Нестатический метод тоже может вызывать статический.
     */
    public void instanceMethod() {
        printVars(); // Вариант 1: через this (неявно)
    }

    /**
     * ПРАКТИКА #1: Все варианты вызова printVars()
     */
    private static void demonstrateStaticMethodCalls() {
        System.out.println("=== Все способы вызова printVars() ===");

        // 1. Через имя класса (рекомендуемый)
        MethodsFields.printVars();

        // 2. Через объект (компилятор сам найдет статический метод)
        MethodsFields obj1 = new MethodsFields();
        obj1.printVars();

        // 3. Через другой объект того же класса
        MethodsFields obj2 = new MethodsFields();
        obj2.printVars();

        // 4. Из нестатического метода (через this)
        obj1.instanceMethod();

        // 5. Короткая запись (если в том же классе)
        printVars(); // прямо из статического метода

        // 6. Из статического контекста без квалификатора
        callStaticMethodDirectly();
    }

    /**
     * Демонстрация изменения статического поля
     */
    private static void demonstrateStaticFieldModification() {
        System.out.println("\nИзменяем статическое поле:");
        MethodsFields.a = 100; // видно всем объектам
        MethodsFields.printVars(); // a теперь 100
    }

    /**
     * Дополнительный статический метод для демонстрации вызова без квалификатора
     */
    private static void callStaticMethodDirectly() {
        System.out.println("\nВызов из другого статического метода:");
        printVars(); // Можно вызывать без имени класса из другого статического метода
    }
}