package driver;

import transport.Competing;
import transport.Transport;
import transport.Utility;
import java.util.Objects;

public abstract class Driver <T extends Transport & Competing > {
    private String fullName;
    private boolean driverLicense;
    private int experience;

    public Driver(String fullName, boolean driverLicense, int experience) {
        this.fullName = Utility.checkNull(fullName , "Default");
        this.experience = Utility.checkInt(experience,0);
        setDriverLicense(driverLicense);
    }

    public String getFullName() {
        return fullName;
    }
    public boolean getDriverLicense() {
        return driverLicense;
    }
    public int getExperience() {
        return experience;
    }

    public void setFullName(String fullName) {
        this.fullName = Utility.checkNull(fullName , "Default");
    }
    public void setDriverLicense(boolean driverLicense) {
        if (!driverLicense){
            throw new IllegalArgumentException("Необходимо указать тип прав!");
        }
        this.driverLicense = driverLicense;
    }
    public void setExperience(int experience) {
        this.experience = Utility.checkInt(experience,0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driverLicense == driver.driverLicense && experience == driver.experience && Objects.equals(fullName, driver.fullName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fullName, driverLicense, experience);
    }

    public void race(T auto) {
        System.out.println("Водитель " + getFullName() + " управляет автомобилем: " + auto + " и будет участвовать в заезде.");
    }
    public abstract void startMoving();
    public abstract void stop();
    public abstract void refuel();
}