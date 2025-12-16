import java.util.Formatter;
import java.time.LocalDateTime;

public class FormatterDemo {
    /**
     * Практика по форматировании информации
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        System.out.println("\n практика 1");

        String name = "Алексей";
        int age = 28;
        double salary = 125000.75;
        boolean isActive = true;
        char grade = 'A';

        System.out.printf("%%s: %s%n", name);
        System.out.printf("%%d: %d%n", age);
        System.out.printf("%%f: %.2f%n", salary);
        System.out.printf("%%b: %b%n", isActive);
        System.out.printf("%%c: %c%n", grade);

        System.out.println("\n практика 2");
        demonstrateFlush();

        System.out.println("\n практика 3");
        LocalDateTime now = LocalDateTime.now();

        System.out.printf("%%tY: %tY%n", now);
        System.out.printf("%%tH:%%tM:%%tS: %tH:%tM:%tS%n", now, now, now);
        System.out.printf("%%tB: %tB%n", now);
        System.out.printf("%%tA: %tA%n", now);
        System.out.printf("%%tm/%%td: %tm/%td/%tY%n", now, now, now);
    }

    static void demonstrateFlush() {
        try (Formatter formatter = new Formatter()) {
            formatter.format("Данные в буфере: %s%n", "НЕ ВЫВЕДЕНО");
            System.out.println("До flush(): буфер заполнен");

            formatter.flush();
            System.out.println("После flush(): данные выведены");
        }
    }
}