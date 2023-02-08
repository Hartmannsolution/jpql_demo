package facades;

import entities.Department;
import entities.Employee;

import javax.persistence.*;
import java.util.List;

public class Facade implements IFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e", Employee.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Employee getHighestPaid() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e ORDER BY e.salery DESC", Employee.class);
            tq.setMaxResults(1);
            return tq.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Double getAverageSalery() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Double> tq = em.createQuery("SELECT AVG(e.salery) FROM Employee e", Double.class);
            return tq.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Employee> getAllBelowAverage() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("SELECT e FROM Employee e WHERE e.salery < (SELECT AVG(e2.salery) FROM Employee e2)", Employee.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Department getWithMostEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Department> tq = em.createQuery("SELECT d FROM Department d ORDER BY size(d.employees) DESC", Department.class);
            tq.setMaxResults(1);
            return tq.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Department getMostExpensiveSalarySum() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT e.department.id as dept_id, SUM(e.salery) as top_sal FROM Employee e GROUP BY e.department.id ORDER BY top_sal DESC");
            q.setMaxResults(1);
            Object[] o = (Object[]) q.getSingleResult();
            Long id = (Long) o[0];
            Department d = em.find(Department.class, id);
            if (d != null)
                return d;
            else
                return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Department> getDepartmentsWithEmpNamed(String name) {
        //return null;
        throw new UnsupportedOperationException("Not implemented yet");
    }
//    public Employee update(Employee e){
//        EntityManager em = emf.createEntityManager();
//        Employee found = em.find(Employee.class, e.getId());
//        String name = e.getName();
//        if(name!=null)
//            found.setName(name);
//        try{
//            em.getTransaction().begin();
//            em.merge(found);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
}
