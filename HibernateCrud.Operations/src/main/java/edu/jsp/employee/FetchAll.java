package edu.jsp.employee;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAll {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
//		ArrayList<Employee> e = new ArrayList<Employee>();
//		
//		for (int i = 0, n=1; i < 2; n++, i++) 	
//			e.add(i, em.find(Employee.class, n));
//		
//		System.out.println(e);
		
		Query q = em.createQuery("select e from Employee e");
//		System.out.println("Enter Employee Name : ");
//		sc.next();
		List<Employee> le = q.getResultList();
		System.out.println(le);
	}
}
