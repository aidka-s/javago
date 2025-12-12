/**
 * Демонстрация различных типов исключений в Java
 */
public class ExceptionsDemo {
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Виды исключений ===");
        showExceptionTypes();

        System.out.println("\n=== ПРАКТИКА #2: Примеры исключений ===");

        // 1. Ошибка при делении на ноль
        testArithmetic();

        // 2. Выход за пределы массива
        testArrayBounds();

        // 3. Неправильный аргумент метода
        testIllegalArgument();

        // 4. Ошибка приведения типов
        testClassCast();

        // 5. Работа с null
        testNullPointer();
    }

    // Показываем основные типы исключений
    static void showExceptionTypes() {
        System.out.println("Все исключения в Java:");
        System.out.println("Throwable - базовый класс");
        System.out.println("├── Error (серьезные ошибки)");
        System.out.println("│   └── OutOfMemoryError, StackOverflowError");
        System.out.println("└── Exception (обычные исключения)");
        System.out.println("    ├── Проверяемые (checked)");
        System.out.println("    │   └── IOException, SQLException");
        System.out.println("    └── Непроверяемые (unchecked)");
        System.out.println("        └── RuntimeException и его наследники");
    }

    // 1. Деление на ноль
    static void testArithmetic() {
        System.out.println("\n1. ArithmeticException:");
        try {
            int x = 10 / 0; // Делим на ноль
            System.out.println("Результат: " + x);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // 2. Работа с массивом
    static void testArrayBounds() {
        System.out.println("\n2. ArrayIndexOutOfBoundsException:");
        int[] arr = {1, 2, 3, 4, 5};
        try {
            // Пытаемся получить элемент, которого нет
            System.out.println("Элемент 10: " + arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Массив имеет " + arr.length + " элементов");
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // 3. Проверка аргументов
    static void testIllegalArgument() {
        System.out.println("\n3. IllegalArgumentException:");
        try {
            applyDiscount(-100); // Отрицательная сумма
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // Метод, который проверяет входные данные
    static double applyDiscount(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть меньше нуля: " + price);
        }
        return price * 0.8; // Скидка 20%
    }

    // 4. Приведение типов
    static void testClassCast() {
        System.out.println("\n4. ClassCastException:");
        Object obj = "Привет";
        try {
            // Пытаемся привести строку к числу
            Integer num = (Integer) obj;
            System.out.println("Число: " + num);
        } catch (ClassCastException e) {
            System.out.println("Нельзя преобразовать строку в число");
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // 5. Null ссылка
    static void testNullPointer() {
        System.out.println("\n5. NullPointerException:");
        String str = null; // Строка не инициализирована
        try {
            // Вызываем метод у null объекта
            System.out.println("Длина строки: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: пытались использовать null объект");
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}