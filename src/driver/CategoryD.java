package driver;

import transport.Bus;
import transport.Competing;

public class CategoryD <T extends Bus & Competing> extends Driver<T> {

    public CategoryD(String fullName, boolean driverLicense, int experience) {
        super(fullName, driverLicense, experience);
    }

    @Override
    public void race(T auto) {
        super.race(auto);
    }

    @Override
    public void startMoving() {
        System.out.println("Начинаю движение.");
    }
    @Override
    public void stop() {
        System.out.println("Останавливаю автомобиль.");
    }
    @Override
    public void refuel() {
        System.out.println("Заправляю автомобиль.");
    }
}