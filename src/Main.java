import driver.CategoryB;
import driver.CategoryC;
import driver.CategoryD;
import driver.Driver;
import transport.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Sponsor sponsor1 = new Sponsor("BonAqua", 100_000);
        Sponsor sponsor2 = new Sponsor("Bridgestone", 200_000);

        Mechanic<Car> mechanic1 = new Mechanic<Car>("Сергей Иванов", "СТО 1");
        Mechanic<Truck> mechanic2 = new Mechanic<Truck>("Максим Степанов", "СТО 1");
        Mechanic<Transport> mechanic3 = new Mechanic<Transport>("Илья Волков", "СТО 1");

        CategoryB<Car> driverB = new CategoryB<Car>("Сергей", true, 2);
        CategoryC<Truck> driverC = new CategoryC<Truck>("Григорий", true, 4);
        CategoryD<Bus> driverD = new CategoryD<Bus>("Станислав", true, 1);


        Car car1 = new Car("Audi","A8 50 L TDI quattro",3.0);
        car1.addDriver(driverB);
        car1.addMechanic(mechanic1);
        car1.addSponsor(sponsor1, sponsor2);
        Car car2 = new Car("BMW","Z8",3.0);
        Car car3 = new Car("Kia","Sportage 4",2.4);
        Car car4 = new Car("Hyundai","Avante",1.6);

        Truck truck1 = new Truck("Mercedes-Benz","B-901" , 6.6);
        truck1.addDriver(driverC);
        truck1.addMechanic(mechanic2);
        truck1.addSponsor(sponsor2);
        Truck truck2 = new Truck("Nissan", "399", 6.2);
        Truck truck3 = new Truck("Chevrolet","M700", 7.5);
        Truck truck4 = new Truck("Scania","T540", 8.7);

        Bus bus1 = new Bus("Hyundai","Н350",5.5);
        bus1.addDriver(driverD);
        bus1.addMechanic(mechanic3);
        bus1.addSponsor(sponsor1);
        Bus bus2 = new Bus("Kia","Н508",4.6);
        Bus bus3 = new Bus("Икарус","399",4.8);
        Bus bus4 = new Bus("Iveco","320",5.1);

        List<Transport> transports = List.of(
                car1,
                truck1,
                bus1
        );

        for (Transport transport : transports) {
            printInfo(transport);
        }

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCarToTheQueue(car1);
        serviceStation.addCarToTheQueue(car2);
        serviceStation.addTruckToTheQueue(truck1);
        serviceStation.addTruckToTheQueue(truck2);
        serviceStation.technicalInspectionCar();
        serviceStation.technicalInspectionCar();
        serviceStation.technicalInspectionCar();
        serviceStation.technicalInspectionCar();

    }
    public static void printInfo(Transport transport) {
        System.out.println("###############");
        System.out.println("Информация по автомобилю: {Брэнд: " + transport.getBrand() +
                "/ Модель: " + transport.getModel() +
                "/ Объем двигателя: " + transport.getEngineVolume() + " литра.}" );
        System.out.println("Информация по водителям: ");
        for (Driver<?> driver : transport.getDriverList()) {
            System.out.println(driver.getFullName() + " со стажем вождения " + driver.getExperience() + " года.");
        }
        System.out.println("Информация по механикам: ");
        for (Mechanic<?> mechanic : transport.getMechanicList()) {
            System.out.println(mechanic.getFullName() + " из компании " + mechanic.getCompany());
        }
        System.out.println("Информация по спонсорам: ");
        for (Sponsor sponsor : transport.getSponsorList()) {
            System.out.println(sponsor.getName() + " проспонсировал заезд на " + sponsor.getAmountOfSupport() + " рублей.");
        }
        System.out.println("###############");
    }
    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            serviceTransport(transport);
        }
    }
    private static void serviceTransport(Transport transport) {
        try {
            if (!transport.passDiagnostics()){
                throw new RuntimeException("Автомобиль: " + transport.getBrand() + " " + transport.getModel() + " не прошёл диагностику.");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}