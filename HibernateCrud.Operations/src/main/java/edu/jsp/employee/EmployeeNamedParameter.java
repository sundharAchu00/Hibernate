package edu.jsp.employee;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeNamedParameter {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e where e.sal=:sal");
		
		System.out.println("enter salary");
		q.setParameter("sal", sc.nextDouble());
		
		List<Employee> el = q.getResultList();
		System.out.println(el);
	}
}
