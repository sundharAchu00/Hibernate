package edu.jsp.employee;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeePositionalParams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e from Employee e where e.name =?1");
		
		System.out.println("Enter Employee Name ");
		q.setParameter(1, sc.next());
		
		List<Employee> el = q.getResultList();
			
		if (el.isEmpty() == false) {
			System.out.println(el);
		} else {
			System.out.println("Data Not Found.....");
		}
	}
}
