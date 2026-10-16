package Level1_BasicAnnotations.Override;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnSiteWorkerTest {

    @BeforeEach
    void setUp() {
        OnSiteWorker.setGas(50.0);
    }

    @Test
    void calculateSalaryWithGasReturnsExpected() {
        OnSiteWorker worker = new OnSiteWorker("Aldo", "Arias", 18.5);
        assertEquals(790.0, worker.calculateSalary(40), 0.001);
    }

    @Test
    void calculateSalaryWithZeroGasEqualsBaseFormula() {
        OnSiteWorker.setGas(0.0);
        OnSiteWorker worker = new OnSiteWorker("Manuel", "García", 18.50);
        assertEquals(740.0, worker.calculateSalary(40), 0.001);
    }

    @Test
    void getGasReturnsValueSetBySetGas() {
        OnSiteWorker.setGas(75.0);
        assertEquals(75.0, OnSiteWorker.getGas(), 0.001);
    }

    @Test
    void setGasAffectsAllInstances() {
        OnSiteWorker worker1 = new OnSiteWorker("Raul", "Pliego", 18.50);
        OnSiteWorker worker2 = new OnSiteWorker("Jesús", "Lozano", 18.50);

        OnSiteWorker.setGas(50);
        assertEquals(790.0, worker1.calculateSalary(40), 0.001);
        assertEquals(790.0, worker2.calculateSalary(40), 0.001);

        OnSiteWorker.setGas(100.0);
        assertEquals(840.0, worker1.calculateSalary(40), 0.001);
        assertEquals(840.0, worker2.calculateSalary(40), 0.001);
    }

}