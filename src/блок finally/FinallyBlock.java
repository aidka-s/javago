public class FinallyBlock {
    /**
     * Практика по блоку finally
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        System.out.println("1: try БЕЗ catch и finally");
        testTryOnly();

        System.out.println("2: try ТОЛЬКО С finally");
        testTryFinally();

        System.out.println("3: try С ДВУМЯ finally");
        testDoubleFinally();
    }

    //1: try БЕЗ catch и finally
    static void testTryOnly() {
        // ОШИБКА КОМПИЛЯЦИИ!
        /*
        try {
            System.out.println("код в try");
            int x = 10 / 0;  // ArithmeticException
        }
        // ОШИБКА: 'try' without 'catch', 'finally' or resource declarations
        */
        System.out.println(" НЕВОЗМОЖНО! Требуется catch или finally");
    }

    //2: try ТОЛЬКО С finally (Java 7+)
    static void testTryFinally() {
        System.out.println("  ВОЗМОЖНО!");
        try {
            System.out.println("код в try");
            int x = 10 / 0;  // ArithmeticException выбросится
            System.out.println("этот код НЕ выполнится");
        } finally {
            System.out.println("finally ВСЕГДА выполняется!");
        }
        // Программа завершится аварийно после finally
    }

    //3: try С ДВУМЯ finally
    static void testDoubleFinally() {

        System.out.println("НЕВОЗМОЖНО! Только 1 finally");
    }
}