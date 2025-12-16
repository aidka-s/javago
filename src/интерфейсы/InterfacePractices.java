/**
 * Интерфейсы
 * @author Student
 * @version 1.0
 */

// Интерфейс без модификатора (package-private)
interface SimpleInterface {
    String MESSAGE = "Hello from interface";
    void showMessage();
}

// Класс с вложенными интерфейсами
class Container {
    // Protected интерфейс
    protected interface InnerProtected {
        String PROTECTED_MSG = "Protected message";
        void protectedShow();
    }

    // Private интерфейс
    private interface InnerPrivate {
        String PRIVATE_MSG = "Private message";
        void privateShow();
    }

    // Внутренний класс для private интерфейса
    private class PrivateClass implements InnerPrivate {
        public void privateShow() {
            System.out.println("Private: " + PRIVATE_MSG);
        }
    }

    // Метод для демонстрации private интерфейса
    public void testPrivate() {
        PrivateClass pc = new PrivateClass();
        pc.privateShow();
    }
}

// Наследование интерфейсов
interface FirstInterface {
    void firstMethod();
}

interface SecondInterface {
    void secondMethod();
}

// Интерфейс, который наследует другие
interface CombinedInterface extends FirstInterface, SecondInterface {
    void combinedMethod();
}

// Абстрактный класс с частичной реализацией
abstract class PartialClass implements CombinedInterface {
    public void firstMethod() {
        System.out.println("First method implemented");
    }
    // secondMethod и combinedMethod не реализованы
}

// Полная реализация
class FullClass extends PartialClass {
    public void secondMethod() {
        System.out.println("Second method implemented");
    }

    public void combinedMethod() {
        System.out.println("Combined method implemented");
    }
}

// Класс, реализующий несколько интерфейсов
class MultiImpl implements SimpleInterface, Container.InnerProtected {
    public void showMessage() {
        System.out.println("Simple: " + MESSAGE);
    }

    public void protectedShow() {
        System.out.println("Inner: " + PROTECTED_MSG);
    }
}

// Основной класс
public class InterfacePractices {
    public static void main(String[] args) {
        System.out.println("=== Практика с интерфейсами ===\n");

        // 1. Простой интерфейс
        System.out.println("1. Простой интерфейс:");
        MultiImpl multi = new MultiImpl();
        multi.showMessage();
        multi.protectedShow();
        System.out.println();

        // 2. Protected и private интерфейсы
        System.out.println("2. Вложенные интерфейсы:");
        Container container = new Container();
        container.testPrivate();
        System.out.println();

        // 3. Наследование интерфейсов
        System.out.println("3. Наследование интерфейсов:");
        FullClass full = new FullClass();
        full.firstMethod();
        full.secondMethod();
        full.combinedMethod();
        System.out.println();

        // 4. Поля интерфейсов
        System.out.println("4. Константы в интерфейсах:");
        System.out.println("Константа: " + SimpleInterface.MESSAGE);
        System.out.println("Защищенная: " + Container.InnerProtected.PROTECTED_MSG);
        System.out.println();

        // 5. Реализация двух интерфейсов
        System.out.println("5. Два интерфейса в одном классе:");
        class Test implements FirstInterface, SecondInterface {
            public void firstMethod() {
                System.out.println("First interface method");
            }

            public void secondMethod() {
                System.out.println("Second interface method");
            }
        }

        Test test = new Test();
        test.firstMethod();
        test.secondMethod();
    }
}