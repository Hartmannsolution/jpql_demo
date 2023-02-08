package facades;

import entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IFacadeTest {
    IFacade facade = new Facade();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllEmployees(){
        System.out.println("Get all employees");
        int actual = facade.getAllEmployees().size();
        int expected = 6;
        assertEquals(expected, actual);
    }
    @Test
    void getHighestPaid() {
        System.out.println("Employee with highest pay");
        Employee expected = new Employee("Hallur", 19000);
        Employee actual = facade.getHighestPaid();
        assertEquals(expected, actual);
    }

    @Test
    void getAverageSalery() {
        System.out.println("Get the average salery from all employees");
        double expected = 14166;
        double actual = facade.getAverageSalery();
        assertEquals(expected, actual);
    }

    @Test
    void getAllBelowAverage() {
        System.out.println("Get employees with below average salery ");
        double expected = 14166.666666666666;
        double actual = facade.getAverageSalery();
        assertEquals(expected, actual);
    }

    @Test
    void getWithMostEmployees() {
        System.out.println("Get department with most employees");
        int expected = 4;
        int actual = facade.getWithMostEmployees().getEmployees().size();
        assertEquals(expected, actual);
    }

    @Test
    void getMostExpensiveSalarySum() {
        System.out.println("Get department with most expensive salary sum");
        String expected = "Holsterbro";
        String actual = facade.getMostExpensiveSalarySum().getName();
        assertEquals(expected, actual);
    }
}