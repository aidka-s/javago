public class Exceptionsomething {
    /**
     * Пример кода с генерацией двух исключений, одно из которых будет "перхвачено", а другое приведет к аварийной остановке
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        System.out.println("работа началась");

        try {
            System.out.println("\n 1. перехваченное исключение:");
            handledException();

            System.out.println("\n 2. неперехваченное исключение:");
            unhandledException();
        } catch (Exception e) {
            System.out.println("В main поймано: " + e.getClass().getSimpleName());
        }

        System.out.println("\n спасибо за внимание");
    }

    static void handledException() {
        int[] numbers = {1, 2, 3};

        try {
            int value = numbers[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("перехвачено в методе: " + e.getClass().getSimpleName());
        }
    }

    static void unhandledException() {
        int result = 10 / 0;
    }
}