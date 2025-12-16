/**
 * Демонстрация наследования в Java
 * @author Student
 * @version 1.0
 */
public class InheritanceDemo {

    public static void main(String[] args) {
        demonstrateThisAndSuperUsage();
        demonstrateAccessModifiersInInheritance();
    }

    /**
     * 1: Использование this и super в подклассах
     * this - ссылка на текущий объект (текущий класс)
     * super - ссылка на родительский класс
     */
    private static void demonstrateThisAndSuperUsage() {
        System.out.println("\n 1: Использование this и super");

        C c = new C();
        c.demoThisSuper();
    }

    /**
     * 2: Доступ к полям и методам с разными модификаторами доступа
     * private - доступен только внутри класса
     * default (package-private) - доступен в том же пакете
     * protected - доступен в том же пакете и в подклассах
     * public - доступен везде
     */
    private static void demonstrateAccessModifiersInInheritance() {
        System.out.println("\n 2: Модификаторы доступа при наследовании ");

        C c = new C();

        System.out.println("\n 1. Доступ к методам из класса C:");
        c.method1();     // OK (default → доступен в подклассе в том же пакете)
        c.method2();     // OK (public → всегда доступен)
        c.method3();     // OK (protected → доступен в подклассе)
        // c.method4();  // ОШИБКА! private недоступно в подклассе

        System.out.println("\n 2. Доступ к полям из класса C:");
        System.out.println("a1=" + c.a1);      // OK (default)
        System.out.println("a2=" + c.a2);      // OK (public)
        System.out.println("a3=" + c.a3);      // OK (protected)
        // System.out.println("a4=" + c.a4);   // ОШИБКА! (private)

        System.out.println("\n3. Создание объектов разных классов:");
        AAA aaa = new AAA();
        B b = new B();

        System.out.println("\n Доступ из класса B:");
        b.method1();     // OK
        b.method2();     // OK
        b.method3();     // OK
        // b.method4();  // ОШИБКА!
    }
}

/**
 * Базовый класс (суперкласс) с различными модификаторами доступа
 */
class AAA {
    int a1;           // default (package-private) - доступен в том же пакете
    public int a2;    // public - доступен везде
    protected int a3; // protected - доступен в том же пакете и в подклассах
    private int a4;   // private - доступен только внутри класса AAA

    void method1() {        // default
        System.out.println("AAA.method1() - default доступ");
    }

    public void method2() { // public
        System.out.println("AAA.method2() - public доступ");
    }

    protected void method3() { // protected
        System.out.println("AAA.method3() - protected доступ");
    }

    private void method4() {   // private
        System.out.println("AAA.method4() - private доступ (не видно в подклассах)");
    }

    /**
     * Метод для демонстрации доступа к private полю внутри своего класса
     */
    public void accessPrivateField() {
        System.out.println("Доступ к private полю a4 внутри класса AAA: " + a4);
    }
}

/**
 * Подкласс B, наследует от AAA
 * Наследует все НЕ private поля и методы
 */
class B extends AAA {
    // Наследует:
    // - a1 (default), a2 (public), a3 (protected)
    // - method1() (default), method2() (public), method3() (protected)
    // НЕ наследует:
    // - a4 (private)
    // - method4() (private)

    /**
     * Дополнительный метод в классе B
     */
    public void bMethod() {
        System.out.println("B.bMethod() - собственный метод класса B");
        System.out.println("Может обращаться к унаследованным полям: a1=" + a1 + ", a2=" + a2 + ", a3=" + a3);
    }
}

/**
 * Подкласс C, наследует от B (и косвенно от AAA)
 * Демонстрация многоуровневого наследования
 */
class C extends B {
    /**
     * 1: Демонстрация использования this и super в подклассе
     * this - ссылка на текущий объект класса C
     * super - ссылка на родительский класс B
     */
    void demoThisSuper() {
        System.out.println("Демонстрация this и super:");

        // Использование this - обращение к полям текущего объекта
        this.a1 = 1;     // Текущий класс (C через B)
        this.a2 = 2;
        this.a3 = 3;

        // Использование super - обращение к полям родительского класса
        super.a1 = 10;   // Суперкласс (B/A)
        super.a2 = 20;
        super.a3 = 30;

        // Вызов методов через super
        super.method1(); // Вызов метода из родительского класса
        super.method2(); // Вызов метода из родительского класса

        System.out.println("this.a1=" + this.a1 + ", super.a1=" + super.a1);
        System.out.println("this.a2=" + this.a2 + ", super.a2=" + super.a2);
        System.out.println("this.a3=" + this.a3 + ", super.a3=" + super.a3);

        // Вызов собственного метода класса B
        super.bMethod();
    }

    /**
     * Переопределение метода для демонстрации полиморфизма
     */
    @Override
    public void method2() {
        System.out.println("C.method2() - переопределенный метод");
        // Можно вызвать родительскую версию
        super.method2();
    }
}