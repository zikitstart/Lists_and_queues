package transport;

public class Car extends Transport implements Competing {

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println("Легковой автомобиль начал движение");
    }
    @Override
    public void finishTheMovement() {
        System.out.println("Легковой автомобиль закончил движение");
    }

    @Override
    public boolean passDiagnostics() {
        return false;
    }

    @Override
    public void repair() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " отремонтирован.");
    }

    @Override
    public double pitStop() {
        System.out.println("Пит-стоп для автомобиля: " + getBrand() + " " + getModel() + ".");
        return 0;
    }
    @Override
    public double bestLapTime() {
        System.out.println("Лучшее время круга автомобиля: " + getBrand() + " " + getModel() + ".");
        return 0;
    }
    @Override
    public int maxSpeed() {
        System.out.println("Максимальная скорость автомобиля: " + getBrand() + " " + getModel() + ".");
        return 0;
    }

    @Override
    public String toString() {
        return "{Брэнд: " + getBrand() +
                " / Модель: " + getModel() +
                " / Объем двигателя: " + getEngineVolume() + " литра.}";
    }
}