package transport;

public class Truck extends Transport implements Competing {

    public Truck(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void startMoving() {
        System.out.println("Грузовой автомобиль начал движение");
    }
    @Override
    public void finishTheMovement() {
        System.out.println("Грузовой автомобиль закончил движение");
    }

    @Override
    public boolean passDiagnostics() {
        return false;
    }

    @Override
    public void repair() {
        System.out.println("Грузовик " + getBrand() + " " + getModel() + " отремонтирован.");
    }

    @Override
    public double pitStop() {
        System.out.println("Пит-стоп для грузовика: " + getBrand() + " " + getModel() + ".");
        return 0;
    }
    @Override
    public double bestLapTime() {
        System.out.println("Лучшее время круга грузовика: " + getBrand() + " " + getModel() + ".");
        return 0;
    }
    @Override
    public int maxSpeed() {
        System.out.println("Максимальная скорость грузовика: " + getBrand() + " " + getModel() + ".");
        return 0;
    }

    @Override
    public String toString() {
        return "{Брэнд: " + getBrand() +
                " / Модель: " + getModel() +
                " / Объем двигателя: " + getEngineVolume() + " литра}";
    }
}