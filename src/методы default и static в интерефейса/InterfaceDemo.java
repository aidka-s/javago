interface Vehicle {
    void start();

    default void stop() {
        System.out.println("Транспорт остановлен");
    }

    static double getMaxSpeed() {
        return 200.0;
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Автомобиль завелся");
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль остановился");
    }
}

interface MobileDevice {
    void turnOn();

    default void turnOff() {
        System.out.println("Устройство выключено");
    }
}

interface SmartDevice {
    void turnOn();

    default void turnOff() {
        System.out.println("Умное устройство отключено");
    }
}

class Smartphone implements MobileDevice, SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Смартфон включен");
    }

    @Override
    public void turnOff() {
        System.out.println("Смартфон выключен");
    }
}

public class InterfaceDemo {
    /**
     * Демонстрация методов default и static в интерфейсах
     * @author Student
     * @version 1.0
     */
    public static void main(String[] args) {
        System.out.println("\n практика 1");

        System.out.println("Максимальная скорость: " + Vehicle.getMaxSpeed());

        Car car = new Car();
        car.start();
        car.stop();

        Vehicle vehicle = car;
        vehicle.start();
        vehicle.stop();

        System.out.println("\n практика 2");

        Smartphone phone = new Smartphone();
        phone.turnOn();
        phone.turnOff();

        MobileDevice mobile = phone;
        mobile.turnOn();
        mobile.turnOff();

        SmartDevice smart = phone;
        smart.turnOn();
        smart.turnOff();
    }
}