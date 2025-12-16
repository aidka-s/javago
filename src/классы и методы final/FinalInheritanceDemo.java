public class FinalInheritanceDemo {
    /**
     * Практики по кодам, благодаря которым невозможно переопределять в подкласее
     * final-метод суперкласса и использовать наследование для final-класса
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        FinalClassDemo obj = new FinalClassDemo();
        obj.method(); // Работает

        // FinalMethodDemo вызовет ошибку компиляции!
        // new FinalChild(); // ОШИБКА!
    }
}

// 1: final метод - НЕЛЬЗЯ переопределить
class FinalMethodDemo {
    public final void method() {
        System.out.println("\n Final метод суперкласса");
    }
}

/*
class FinalChild extends FinalMethodDemo {  // ОШИБКА КОМПИЛЯЦИИ!
    @Override
    public void method() {  // cannot override the final method from FinalMethodDemo
        System.out.println("Попытка переопределить final метод");
    }
}
*/

// 2: final класс - НЕЛЬЗЯ наследовать
final class FinalClassDemo {
    public void method() {
        System.out.println("\n Метод final класса");
    }
}

/*
class FinalClassChild extends FinalClassDemo {  // ОШИБКА КОМПИЛЯЦИИ!
    // cannot inherit from final FinalClassDemo
}
*/