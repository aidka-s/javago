public class LogicBlocks {
    /**
     * Практика по логическим блокам
     * @author Student
     * @version 1.0
     */
    {
        System.out.println("logic (1) id= " + this.id);  // 0 (значение по умолчанию)
    }

    static {
        System.out.println("static logic");              // Выполняется ПЕРВЫМ!
    }

    private int id = 1;  // Инициализация ПОЗЖЕ

    public LogicBlocks(int id) {
        this.id = id;  // 100
        System.out.println("ctor id= " + id);
    }

    {
        System.out.println("logic (2) id= " + id);       // 1 (поле уже инициализировано)
    }
}

class Main2 {
    public static void main(String[] args) {
        System.out.println("=== Создание new A(100) ===");
        new LogicBlocks(100);
    }
}
