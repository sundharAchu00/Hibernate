package edu.jsp.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		
		EntityManager em = emf.createEntityManager();
		
		
	Employee e = em.find(Employee.class, 1);
	Employee e1 = em.find(Employee.class, 2);
	System.out.println(e);
	System.out.println(e1);
	}
}
