package Level1_BasicAnnotations.Override;

public class OnSiteWorker extends Worker {

    private static double benzina;

    public OnSiteWorker(String name, String surname, double salaryPerHour) {
        super(name, surname, salaryPerHour);
    }

    public static double getBenzina() {
        return benzina;
    }

    public static void setBenzina(double benzina) {
        OnSiteWorker.benzina = benzina;
    }

    @Override
    public double calculateSalary(double workedHours) {
        return super.calculateSalary(workedHours) + benzina;
    }
}
