package Level1_BasicAnnotations.Override;

public class OnSiteWorker extends Worker {

    private static double gas;

    public OnSiteWorker(String name, String surname, double salaryPerHour) {
        super(name, surname, salaryPerHour);
    }

    public static double getGas() {
        return gas;
    }

    public static void setGas(double gas) {
        OnSiteWorker.gas = gas;
    }

    @Override
    public double calculateSalary(double workedHours) {
        return super.calculateSalary(workedHours) + gas;
    }

    @Deprecated
    public double calculateSalaryOld(double workedHours) {
        return super.calculateSalary(workedHours);
    }

}
