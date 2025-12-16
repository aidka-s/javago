public class SwitchDemo {
    /**
     * Демонстрация всех возможных типов switch и fall-through.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("=== ПРАКТИКА #1: Все возможные типы switch ===\n");

        demonstrateAllSwitchTypes();

        System.out.println("\n\n=== ПРАКТИКА #2: Fall-through (отсутствие break) ===");

        demonstrateFallThrough();

        System.out.println("\n\n=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===");

        demonstrateSwitchExpressions();
        demonstrateDefaultBehavior();
    }

    // ПРАКТИКА #1: Все возможные типы switch
    private static void demonstrateAllSwitchTypes() {
        System.out.println("1. Примитивные типы и их обертки:");

        // 1. byte, short, int, char (и их wrapper'ы)
        byte b = 1;
        switch (b) {
            case 1:
                System.out.println("   byte: " + b);
                break;
            default:
                System.out.println("   Неизвестное значение byte");
        }

        short s = 2;
        switch (s) {
            case 2:
                System.out.println("   short: " + s);
                break;
            default:
                System.out.println("   Неизвестное значение short");
        }

        int i = 3;
        switch (i) {
            case 3:
                System.out.println("   int: " + i);
                break;
            case 4:
                System.out.println("   int: другое значение");
                break;
            default:
                System.out.println("   Неизвестное значение int");
        }

        char c = 'A';
        switch (c) {
            case 'A':
                System.out.println("   char: " + c);
                break;
            case 'B':
                System.out.println("   char: B");
                break;
            default:
                System.out.println("   Неизвестный символ");
        }

        // Обертки (autoboxing)
        Integer integerValue = 5;
        switch (integerValue) {
            case 5:
                System.out.println("   Integer: " + integerValue);
                break;
            default:
                System.out.println("   Неизвестное значение Integer");
        }

        System.out.println("\n2. String (Java 7+):");
        String str = "Hello";
        switch (str) {
            case "Hello":
                System.out.println("   String: " + str);
                break;
            case "World":
                System.out.println("   String: World");
                break;
            default:
                System.out.println("   Неизвестная строка");
        }

        System.out.println("\n3. Enum:");
        Day day = Day.MONDAY;
        switch (day) {
            case MONDAY:
                System.out.println("   enum: " + day + " - начало недели");
                break;
            case TUESDAY:
                System.out.println("   enum: " + day + " - второй день");
                break;
            case WEDNESDAY:
                System.out.println("   enum: " + day + " - середина недели");
                break;
            default:
                System.out.println("   Неизвестный день");
        }
    }

    // ПРАКТИКА #2: Fall-through (отсутствие break)
    private static void demonstrateFallThrough() {
        System.out.println("\nПример 1: Классический fall-through");
        int value = 2;
        int result = 0;
        switch (value) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                // Нет break - fall-through!
                System.out.println("   Выполнился case 2, но нет break!");
            case 3:
                result = 3;  // Выполнится для value=2!
                System.out.println("   Выполнился case 3 (fall-through)");
                break;
            default:
                result = 99;
        }
        System.out.println("   value=2 → result=" + result); // Выведет 3!

        System.out.println("\nПример 2: Intentional fall-through (несколько case для одного блока кода)");
        int month = 2;
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Зима";
                System.out.println("   Месяц " + month + " - это " + season);
                break;
            case 3:
            case 4:
            case 5:
                season = "Весна";
                System.out.println("   Месяц " + month + " - это " + season);
                break;
            default:
                season = "Неизвестный сезон";
                System.out.println("   Неизвестный месяц");
        }
    }

    // Дополнительные примеры
    private static void demonstrateSwitchExpressions() {
        System.out.println("\n4. Switch expressions (Java 14+ стиль):");

        Day today = Day.WEDNESDAY;
        String message = switch (today) {
            case MONDAY -> "Понедельник - тяжелый день";
            case TUESDAY -> "Вторник - работаем дальше";
            case WEDNESDAY -> "Среда - маленькая пятница";
            default -> "Другой день";
        };
        System.out.println("   " + message);
    }

    private static void demonstrateDefaultBehavior() {
        System.out.println("\n5. Поведение по умолчанию:");

        int testValue = 99;
        switch (testValue) {
            case 1:
                System.out.println("   Значение равно 1");
                break;
            case 2:
                System.out.println("   Значение равно 2");
                break;
            default:
                System.out.println("   Значение " + testValue + " не обработано в case");
        }
    }

    // enum для switch
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}