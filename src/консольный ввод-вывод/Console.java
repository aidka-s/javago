import java.util.Scanner;

public class Console {
    /**
     * Консольный ввод-вывод
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Привет, " + name + "!");

        scanner.close();
    }
}