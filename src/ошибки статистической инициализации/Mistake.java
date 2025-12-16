/**
 * Пояснение почему программа не работает
 * @author Student
 * @version 1.0
 */

public class App {
    final static int START_COUNTER;
    static {
        START_COUNTER = Integer.parseInt("Y-");
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

/**
 * При выполнении этого кода программа не выведет "Hello", а завершится с ошибкой NumberFormatException на этапе загрузки класса.
 *
 * Объяснение:
 * Integer.parseInt("Y-") пытается преобразовать строку "Y-" в число
 *
 * Строка "Y-" не является числом, поэтому выбрасывается NumberFormatException
 *
 * Исключение возникает в статическом блоке инициализации
 *
 * Так как исключение не обрабатывается, программа падает на этапе загрузки класса
 *
 * Метод main() не выполняется вообще
 *
 * Вывод будет вот таким:
 * Exception in thread "main" java.lang.NumberFormatException: For input string: "Y-"
 *     at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
 *     at java.lang.Integer.parseInt(Integer.java:580)
 *     at java.lang.Integer.parseInt(Integer.java:615)
 *     at App.<clinit>(App.java:4)
 */