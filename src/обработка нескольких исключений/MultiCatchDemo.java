class BaseException extends Exception {
    public BaseException(String message) {
        super("BaseException: " + message);
    }
}

class MiddleException extends BaseException {
    public MiddleException(String message) {
        super(message);
    }
}

class ChildException extends MiddleException {
    public ChildException(String message) {
        super("ChildException: " + message);
    }
}

public class MultiCatchDemo {
    /**
     * пример кода, в котором продемонстрированы следующие ситуации:
     * несколько исключений обрабатываются абсолютно идентичным образом;
     * исключения, которые обрабатываются, образуют иерархию Ex1 <|-- Ex2 <|-- Ex3, т.е. Ex3 - подкласс Ex2, а Ex2 - подкласс Ex1.
     * а ещё тут объяснено использование final в объявлении (не газетном)
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        System.out.println("\n практика 1");

        System.out.println("\n 1. Multi-catch:");
        try {
            riskyOperation1();
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Multi-catch: " + e.getClass().getSimpleName());
        }

        System.out.println("\n 2. Иерархия исключений:");
        demonstrateHierarchy();

        System.out.println("\n практика 2");
        demonstrateFinal();
    }

    static void riskyOperation1() {
        int[] arr = {1, 2, 3};
        int x = 10 / 0;
        int y = arr[5];
    }

    static void demonstrateHierarchy() {
        try {
            throw new ChildException("Ошибка");
        } catch (ChildException e) {
            System.out.println("catch ChildException");
        } catch (MiddleException e) {
            System.out.println("catch MiddleException");
        } catch (BaseException e) {
            System.out.println("catch BaseException");
        }
    }

    static void demonstrateFinal() {
        try {
            riskyOperationWithFinal();
        } catch (final Exception e) {
            System.out.println("final Exception: " + e.getClass().getSimpleName());
        }
    }

    static void riskyOperationWithFinal() throws ChildException {
        throw new ChildException("final");
    }
}