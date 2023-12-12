package edu.jsp.employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateEmployee {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e = em.find(Employee.class, 3);
		if (e!=null) {
			e.setPhone_number(8098578375l);
			et.begin();
			em.persist(e);
			et.commit();
		} else {
			System.out.println("data not found");
		}
		
		
		
		
	}
}
