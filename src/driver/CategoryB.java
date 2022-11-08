package driver;

import transport.Car;
import transport.Competing;

public class CategoryB <T extends Car & Competing> extends Driver<T> {

    public CategoryB(String fullName, boolean driverLicense, int experience) {
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