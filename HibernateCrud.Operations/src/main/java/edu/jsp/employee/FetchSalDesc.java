package edu.jsp.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchSalDesc {
	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e order by sal desc");
		List<Employee> e = q.getResultList();
		System.out.println(e);
	}
}
