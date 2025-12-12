/**
 * Практическое изучение методов decode() и особенностей работы
 * с обертками примитивных типов в Java
 */
public class NumberWrappers {

    public static void main(String[] args) {
        // Часть 1 - Разбор строк в числа
        decodeExamples();

        // Часть 2 - Разные способы создания Boolean
        booleanCreation();

        // Часть 3 - Опасности при работе с null
        nullSafetyDemo();

        // Часть 4 - Особенности сравнения Integer
        integerComparison();
    }

    /**
     * Часть 1 - Использование метода decode()
     * для преобразования строк в числа
     */
    public static void decodeExamples() {
        System.out.println("=== Часть 1: Метод decode() ===");

        // Метод decode умеет работать с разными форматами записи чисел
        // Обычные десятичные числа
        Integer num1 = Integer.decode("42");
        Integer num2 = Integer.decode("99");
        System.out.println("Десятичные числа:");
        System.out.println("decode(\"42\") -> " + num1);
        System.out.println("decode(\"99\") -> " + num2);

        // Числа в восьмеричной системе (начинаются с нуля)
        Integer octNum1 = Integer.decode("010"); // 8 в десятичной
        Integer octNum2 = Integer.decode("077"); // 63 в десятичной
        System.out.println("\nВосьмеричные числа (начинаются с 0):");
        System.out.println("decode(\"010\") = " + octNum1 + " (8 в 10-чной)");
        System.out.println("decode(\"077\") = " + octNum2 + " (63 в 10-чной)");

        // Шестнадцатеричные числа
        Integer hexNum1 = Integer.decode("0xA");    // 10
        Integer hexNum2 = Integer.decode("0XFF");   // 255
        Integer hexNum3 = Integer.decode("#1F");    // 31
        System.out.println("\nШестнадцатеричные числа:");
        System.out.println("decode(\"0xA\") = " + hexNum1);
        System.out.println("decode(\"0XFF\") = " + hexNum2);
        System.out.println("decode(\"#1F\") = " + hexNum3);

        // Отрицательные значения тоже поддерживаются
        Integer neg1 = Integer.decode("-50");
        Integer neg2 = Integer.decode("-0x2A"); // -42
        System.out.println("\nОтрицательные числа:");
        System.out.println("decode(\"-50\") = " + neg1);
        System.out.println("decode(\"-0x2A\") = " + neg2);

        // Работа с типом Long
        Long bigNum = Long.decode("0x7FFFFFFFFFFFFFFF");
        System.out.println("\nДля типа Long:");
        System.out.println("Long.decode(\"0x7FFFFFFFFFFFFFFF\") = " + bigNum);

        System.out.println();
    }

    /**
     * Часть 2 - Варианты создания объектов Boolean
     */
    public static void booleanCreation() {
        System.out.println("=== Часть 2: Создание Boolean объектов ===");

        // 1. Конструкторы (устаревший способ)
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("YES"); // false для любой строки кроме "true"

        System.out.println("Через конструктор (устаревшее):");
        System.out.println("new Boolean(true) -> " + b1);
        System.out.println("new Boolean(\"true\") -> " + b2);
        System.out.println("new Boolean(\"YES\") -> " + b3);

        // 2. Метод valueOf (рекомендуемый)
        Boolean b4 = Boolean.valueOf(true);
        Boolean b5 = Boolean.valueOf("true");
        Boolean b6 = Boolean.valueOf("True");
        Boolean b7 = Boolean.valueOf("any text");

        System.out.println("\nЧерез valueOf (рекомендуется):");
        System.out.println("Boolean.valueOf(true) -> " + b4);
        System.out.println("Boolean.valueOf(\"true\") -> " + b5);
        System.out.println("Boolean.valueOf(\"True\") -> " + b6);
        System.out.println("Boolean.valueOf(\"any text\") -> " + b7);

        // 3. parseBoolean для примитивов
        boolean pb1 = Boolean.parseBoolean("true");
        boolean pb2 = Boolean.parseBoolean("false");
        boolean pb3 = Boolean.parseBoolean("TRUE");
        boolean pb4 = Boolean.parseBoolean("some text");

        System.out.println("\nparseBoolean (возвращает boolean):");
        System.out.println("parseBoolean(\"true\") -> " + pb1);
        System.out.println("parseBoolean(\"TRUE\") -> " + pb3);
        System.out.println("parseBoolean(\"some text\") -> " + pb4);

        // 4. Прямое присваивание и константы
        Boolean direct1 = true;          // автоупаковка
        Boolean direct2 = Boolean.TRUE;  // использование констант
        Boolean direct3 = Boolean.FALSE;

        System.out.println("\nАвтоупаковка и константы:");
        System.out.println("Boolean direct1 = true -> " + direct1);
        System.out.println("Boolean.TRUE -> " + direct2);
        System.out.println("Boolean.FALSE -> " + direct3);

        System.out.println();
    }

    /**
     * Часть 3 - Потенциальные проблемы с null значениями
     */
    public static void nullSafetyDemo() {
        System.out.println("=== Часть 3: Работа с null значениями ===");

        // Создаем null ссылки на обертки
        Integer nullInt = null;
        Double nullDouble = null;
        Boolean nullBool = null;

        // Попытка распаковки null вызовет исключение
        System.out.println("Примеры опасных операций:");

        try {
            System.out.print("Попытка: int i = nullInt -> ");
            int i = nullInt; // Здесь будет исключение
            System.out.println("Успех: " + i);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException!");
        }

        try {
            System.out.print("Попытка: double d = nullDouble -> ");
            double d = nullDouble;
            System.out.println("Успех: " + d);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException!");
        }

        try {
            System.out.print("Попытка: boolean b = nullBool -> ");
            boolean b = nullBool;
            System.out.println("Успех: " + b);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException!");
        }

        // Арифметические операции с null
        try {
            System.out.print("Попытка: nullInt + 5 -> ");
            int result = nullInt + 5;
            System.out.println("Успех: " + result);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: NullPointerException!");
        }

        // Безопасные операции с null
        System.out.println("\nБезопасные операции:");
        System.out.println("nullInt == null -> " + (nullInt == null));
        System.out.println("nullInt != null -> " + (nullInt != null));

        // Присваивание null безопасно
        Integer safeNull = null;
        System.out.println("Integer safeNull = null -> корректно");

        System.out.println();
    }

    /**
     * Часть 4 - Нюансы сравнения объектов Integer
     */
    public static void integerComparison() {
        System.out.println("=== Часть 4: Сравнение Integer объектов ===");

        System.out.println("=== Сравнение 200 (вне кэша) ===");
        int base1 = 200;
        Integer obj1 = base1;
        Integer obj2 = base1;

        System.out.println("int base1 = 200");
        System.out.println("Integer obj1 = base1");
        System.out.println("Integer obj2 = base1");
        System.out.println("obj1 == base1 -> " + (obj1 == base1)); // true
        System.out.println("obj2 == base1 -> " + (obj2 == base1)); // true
        System.out.println("obj1 == obj2 -> " + (obj1 == obj2));   // false!
        System.out.println("obj1.equals(obj2) -> " + obj1.equals(obj2)); // true

        System.out.println("\n=== Сравнение 100 (в кэше) ===");
        int base2 = 100;
        Integer obj3 = base2;
        Integer obj4 = base2;

        System.out.println("int base2 = 100");
        System.out.println("Integer obj3 = base2");
        System.out.println("Integer obj4 = base2");
        System.out.println("obj3 == base2 -> " + (obj3 == base2)); // true
        System.out.println("obj4 == base2 -> " + (obj4 == base2)); // true
        System.out.println("obj3 == obj4 -> " + (obj3 == obj4));   // true!
        System.out.println("obj3.equals(obj4) -> " + obj3.equals(obj4)); // true

        // Прямая демонстрация кэширования
        System.out.println("\n=== Демонстрация IntegerCache ===");

        Integer val1 = Integer.valueOf(50);
        Integer val2 = Integer.valueOf(50);
        System.out.println("Integer.valueOf(50) == Integer.valueOf(50): " + (val1 == val2));

        Integer val3 = Integer.valueOf(150);
        Integer val4 = Integer.valueOf(150);
        System.out.println("Integer.valueOf(150) == Integer.valueOf(150): " + (val3 == val4));

        // Границы кэша
        Integer val5 = Integer.valueOf(127);
        Integer val6 = Integer.valueOf(127);
        Integer val7 = Integer.valueOf(128);
        Integer val8 = Integer.valueOf(128);
        System.out.println("Граница кэша (127): " + (val5 == val6));
        System.out.println("За границей (128): " + (val7 == val8));

        // Отрицательные числа
        Integer val9 = Integer.valueOf(-100);
        Integer val10 = Integer.valueOf(-100);
        Integer val11 = Integer.valueOf(-200);
        Integer val12 = Integer.valueOf(-200);
        System.out.println("Отрицательное в кэше (-100): " + (val9 == val10));
        System.out.println("Отрицательное вне кэша (-200): " + (val11 == val12));

        System.out.println("\nВажный вывод: для сравнения объектов всегда используйте equals()!");
    }
}

/**
 * Дополнительный класс с примерами сравнения разных числовых типов
 */
class NumberExamples {
    public static void showComparisons() {
        System.out.println("\n=== Дополнительные примеры ===");

        // Сравнение через compareTo
        Integer first = 50;
        Integer second = 100;
        System.out.println("first.compareTo(second): " + first.compareTo(second));
        System.out.println("second.compareTo(first): " + second.compareTo(first));
        System.out.println("first.compareTo(first): " + first.compareTo(first));

        // Сравнение разных типов
        Number numInt = 100;
        Number numDouble = 100.0;
        System.out.println("Integer 100 equals Double 100.0: " + numInt.equals(numDouble));
    }
}