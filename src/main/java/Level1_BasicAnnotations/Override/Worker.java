package Level1_BasicAnnotations.Override;

public class Worker {

    private String name;
    private String surname;
    private double salaryPerHour;

    public Worker(String name, String surname, double salaryPerHour) {
        this.name = name;
        this.surname = surname;
        this.salaryPerHour = salaryPerHour;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public double calculateSalary(double workedHours) {
        double salary = salaryPerHour * workedHours;
        return salary;
    }

}
