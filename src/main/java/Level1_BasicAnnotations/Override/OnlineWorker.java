package Level1_BasicAnnotations.Override;

public class OnlineWorker extends Worker {

    private static final double INTERNET_FLAT_RATE = 19.90;

    public OnlineWorker(String name, String surname, double salaryPerHour) {
        super(name, surname, salaryPerHour);
    }

    @Override
    public double calculateSalary(double workedHours) {
        return super.calculateSalary(workedHours) + INTERNET_FLAT_RATE;
    }

    @Deprecated
    public double calculateSalaryObsolete(double workedHours) {
        return super.calculateSalary(workedHours);
    }
}
