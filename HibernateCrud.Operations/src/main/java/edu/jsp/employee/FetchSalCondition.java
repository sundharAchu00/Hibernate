package edu.jsp.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchSalCondition {
	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e where e.sal between 57000 and 100000");
		List<Employee> le = q.getResultList();
//		Employee e = (Employee)
		System.out.println(le);
	}
}
