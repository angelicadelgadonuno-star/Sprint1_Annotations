package Level1_BasicAnnotations.Override;

public class Main {
    public static void main(String[] args) {

        OnSiteWorker.setGas(50.0);

        Worker worker = new Worker("Sandra", "Morales", 17.50);
        Worker onSiteWorker = new OnSiteWorker("Alejandro", "Díaz", 19.5);
        Worker onlineWorker = new OnlineWorker("Iciar", "Algorri", 18.50);

        Worker[] workers = {worker, onSiteWorker, onlineWorker};

        for (Worker w : workers) {
            System.out.println("The salary of " + w.getName() + " " + w.getSurname() + " → " + w.calculateSalary(40) + "€");
        }
    }
}
