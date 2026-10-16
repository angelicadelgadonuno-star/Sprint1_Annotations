package Level1_BasicAnnotations.Override;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    @Test
    void calculateWorkerSalaryReturnsSalary() {
        Worker worker = new Worker("Sandra", "Morales",17.50);
        double result = worker.calculateSalary(40);
        assertEquals(700.0, result, 0.001);
    }

    @Test
    void calculateSalaryForZeroHoursWorkedReturnsZero() {
        Worker worker = new Worker("Leandro", "Martinez", 18.50);
        double result = worker.calculateSalary(0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void getWorkerNameReturnsName() {
        Worker worker = new Worker("Laura", "García", 19.50);
        assertEquals("Laura", worker.getName());
    }

    @Test
    void getWorkerSurnameReturnsSurname() {
        Worker worker = new Worker("Altair", "Pedregal", 18.50);
        assertEquals("Pedregal", worker.getSurname());
    }

    @Test
    void getWorkerSalaryPerHourReturnsSalaryPerHour() {
        Worker worker = new Worker("Juan", "Pedregal", 17.50);
        assertEquals(17.50, worker.getSalaryPerHour(), 0.001);
    }
}