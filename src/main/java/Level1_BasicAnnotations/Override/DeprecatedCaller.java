package Level1_BasicAnnotations.Override;

public class DeprecatedCaller {

    @SuppressWarnings("deprecation")
    public void callDeprecatedMethods() {
        OnSiteWorker onSite = new OnSiteWorker("Alejandro", "Diaz", 19.5);
        double oldSalary = onSite.calculateSalaryOld(40);

        OnlineWorker online = new OnlineWorker("Iciar", "Algorri", 18.50);
        double obsoleteSalary = online.calculateSalaryObsolete(40);

        System.out.println(onSite.getName() + " " + onSite.getSurname() + " old salary: " + oldSalary);
        System.out.println(online.getName() + " " + online.getSurname() + " obsolete salary: " + obsoleteSalary);
    }

}
