package utils;

import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate {
    public static void main(String[] args) {
//
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Employee e1 = new Employee("Henry", 11000);
            Employee e2 = new Employee("Hans", 16000);
            Employee e3 = new Employee("Helga", 14000);
            Employee e4 = new Employee("Hussein", 13000);
            Employee e5 = new Employee("Hung", 12000);
            Employee e6 = new Employee("Hallur", 19000);

            Department d1 = new Department("Holsterbro");
            Department d2 = new Department("Kolding");
            d1.addEmployees(e1);
            d1.addEmployees(e2);
            d1.addEmployees(e3);
            d1.addEmployees(e4);
            d2.addEmployees(e5);
            d2.addEmployees(e6);
            em.persist(d1);
            em.persist(d2);
            em.persist(e1);
            em.persist(e2);
            em.persist(e3);
            em.persist(e4);
            em.persist(e5);
            em.persist(e6);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
