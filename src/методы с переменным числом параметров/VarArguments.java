public class VarArguments {
    /**
     * Практика по перегруженному методу с переменным числом параметров
     * @author Student
     * @version 1.0
     */
    // Метод с одним int параметром
    public void printNums(int num) {
        System.out.println("Single int: " + num);
    }

    // Метод с переменным количеством int параметров
    public void printNums(int... nums) {
        System.out.print("Varargs ints: ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Перегрузка с другим типом параметров
    public void printNums(String prefix, int... nums) {
        System.out.print(prefix + ": ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        VarArguments obj = new VarArguments();

        // Вызов перегруженных методов
        obj.printNums(5);                // Один параметр
        obj.printNums(1, 2, 3, 4, 5);   // Переменный аргумент
        obj.printNums("Numbers", 10, 20, 30); // Перегрузка с префиксом и varargs
    }
}