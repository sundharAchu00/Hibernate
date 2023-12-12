package edu.jsp.employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeDriver {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Employee e = new Employee();
		e.setId(3);
		e.setName("sollamatta");
		e.setSal(8600);
		e.setPhone_number(987621234l);
		
		et.begin();
		em.persist(e);
		et.commit();
	}

}
