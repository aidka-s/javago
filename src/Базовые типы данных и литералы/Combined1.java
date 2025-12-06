public class Combined1 {

    private byte defByte;
    private short defShort;
    private int defInt;
    private long defLong;
    private float defFloat;
    private double defDouble;
    private char defChar;
    private boolean defBoolean;

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }
    public static void task1() {
        System.out.println("Практика 1");

        byte b = -128;
        short s = 12345;
        int i = 1000000;
        long l = 90000000000L;
        float f = 1.23f;
        double d = 2.564564648;
        char c = 'Ж';
        boolean flag = false;

        byte zB = 0;
        short zS = 0;
        int zI = 0;
        long zL = 0L;
        float zF = 0.0f;
        double zD = 0.0;
        char zC = '\u0000';
        boolean zBool = false;

        System.out.println("byte: " + b + ", zero: " + zB);
        System.out.println("short: " + s + ", zero: " + zS);
        System.out.println("int: " + i + ", zero: " + zI);
        System.out.println("long: " + l + ", zero: " + zL);
        System.out.println("float: " + f + ", zero: " + zF);
        System.out.println("double: " + d + ", zero: " + zD);
        System.out.println("char: " + c + ", zero: '" + zC + "'");
        System.out.println("boolean: " + flag + ", zero: " + zBool);
        System.out.println();
    }

    public static void task2() {
        System.out.println("Практика 2");

        char k = '\u041A';
        char a = '\u0430';
        char t = '\u0442';
        char e = '\u0435';
        char r = '\u0440';
        char i = '\u0438';
        char n = '\u043D';
        char a2 = '\u0430';

        System.out.println("Имя в Unicode: " + k + a + t + e + r + i + n + a2);
        System.out.println();
    }

    public static void task3() {
        System.out.println("Практика 3");

        int x = 5;
        {
            int y = 10;
            System.out.println("Внутри блока: x=" + x + ", y=" + y);
        }

        System.out.println("Переменная y недоступна вне блока");
        System.out.println();
    }

    public static void task4() {
        System.out.println("Практика 4");

        String city = "Москва";
        int people = 13000000;
        double area = 2561.5;
        Object ref = new Object();

        System.out.println("Город: " + city);
        System.out.println("Население: " + people);
        System.out.println("Площадь: " + area + " км²");
        System.out.println("Объект: " + ref);
        System.out.println(city + " — город с населением " + people);
        System.out.println();
    }

    public static void task5() {
        System.out.println("Практика 5");

        byte b = 5;
        short s = 10;
        int i = 100;
        long l = 5000L;
        float f = 2.5f;
        double d = 0.75;

        int r1 = b + s;
        long r2 = s + l;
        float r3 = l + f;
        double r4 = d + i;

        System.out.println("byte + short = int → " + r1);
        System.out.println("short + long = long → " + r2);
        System.out.println("long + float = float → " + r3);
        System.out.println("double + int = double → " + r4);
        System.out.println();
    }

    public static void task6() {
        System.out.println("Практика 6");

        int big1 = 130;
        int big2 = 1000;
        double pi = 3.99;

        byte b1 = (byte) big1;
        byte b2 = (byte) big2;
        int i1 = (int) pi;

        System.out.println("(byte) 130 = " + b1);
        System.out.println("(byte) 1000 = " + b2 + " (переполнение)");
        System.out.println("(int) 3.99 = " + i1);
        System.out.println();
    }

    public static void task7() {
        System.out.println("Практика 7");

        int a = 115;

        // byte b = a + 5;  // ошибка
        byte c = (byte) (a + 5);
        // byte d = a + 1; // ошибка

        System.out.println("int a = " + a);
        System.out.println("byte c = (byte)(a + 5) = " + c);
        System.out.println("Выражение a + 1 имеет тип int → нужен cast");
        System.out.println();
    }

    public static void task8() {
        System.out.println("Практика 8");

        var text = "Hello";
        var number = 42;
        var price = 9.99;
        var list = new java.util.ArrayList<>();
        var map = new java.util.HashMap<>();

        System.out.println("var text → " + text.getClass().getSimpleName());
        System.out.println("var number → int");
        System.out.println("var price → double");
        System.out.println("var list → " + list.getClass().getSimpleName());
        System.out.println("var map → " + map.getClass().getSimpleName());
        System.out.println();
    }
}
