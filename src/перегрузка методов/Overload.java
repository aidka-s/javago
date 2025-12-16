public class Overload {
    /**
     * Практика по перегрузке методов
     * @author Student
     * @version 1.0
     */

    public static void main(String[] args) {
        demonstrateOverloadingWithForEachLoop();
        demonstrateDirectMethodCalls();
    }

    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }

    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }

    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }

    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }

    /**
     * Демонстрация перегрузки методов в цикле for-each
     */
    private static void demonstrateOverloadingWithForEachLoop() {
        System.out.println("=== Цикл for-each (1) ===");
        Overload a = new Overload();
        Number[] num = {new Integer(1), 11, 1.11f, 11.11};

        for (Number n : num) {
            a.printNum(n);  // ВСЕгда Number!
        }
    }

    /**
     * Демонстрация прямых вызовов перегруженных методов
     */
    private static void demonstrateDirectMethodCalls() {
        System.out.println("\n=== Прямые вызовы (2) ===");
        Overload a = new Overload();

        a.printNum(new Integer(1));  // Integer
        a.printNum(11);              // int
        a.printNum(1.11f);           // Float
        a.printNum(11.11);           // double → Number (нет double метода!)
    }
}