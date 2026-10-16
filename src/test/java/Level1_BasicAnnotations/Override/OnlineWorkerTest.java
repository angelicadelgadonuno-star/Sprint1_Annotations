package Level1_BasicAnnotations.Override;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlineWorkerTest {

    @Test
    void calculateSalaryWithHoursReturnsBasePlusFlatRate() {
        OnlineWorker worker = new OnlineWorker("Abel", "Nuño", 18.50);
        assertEquals(759.90, worker.calculateSalary(40), 0.001);
    }

    @Test
    void calculateSalaryWithZeroHoursReturnsFlatRate() {
        OnlineWorker worker = new OnlineWorker("Carlos", "Perdomo", 18.50);
        assertEquals(19.90, worker.calculateSalary(0), 0.001);
    }

    @Test
    void flatRateIsSharedAcrossInstances() {
        OnlineWorker workerA = new OnlineWorker("Adrian", "Fuertes", 10.0);
        OnlineWorker workerB = new OnlineWorker("Eva", "Moreno", 20.0);
        assertEquals(19.90, workerA.calculateSalary(0), 0.001);
        assertEquals(19.90, workerB.calculateSalary(0), 0.001);
    }
}