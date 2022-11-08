package transport;

import java.util.Objects;

public class Mechanic<T extends Transport> {
    private String fullName;
    private String company;

    public Mechanic(String name, String company) {
        this.fullName = Utility.checkNull(name, "Default");
        this.company = Utility.checkNull(company, "Default");
    }

    public String getFullName() {
        return fullName;
    }
    public String getCompany() {
        return company;
    }

    public void setFullName(String fullName) {
        this.fullName = Utility.checkNull(fullName, "Default");
    }
    public void setCompany(String company) {
        this.company = Utility.checkNull(company, "Default");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(fullName, mechanic.fullName) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, company);
    }

    public boolean performMaintenance(T t) {
        return t.passDiagnostics();
    }
    public void fixTheCar(T t) {
        t.repair();
    }
}
