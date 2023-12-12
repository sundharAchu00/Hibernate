package edu.jsp.employee;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmpFetchNamedByBet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e.name,e.sal from Employee e where e.sal between :start and :end order by sal desc");
		
		System.out.println("Enter Starting range ");
		q.setParameter("start", sc.nextDouble());
		System.out.println("Enter Ending Range");
		q.setParameter("end", sc.nextDouble());
		
		List<Object[]> el = q.getResultList();
		
		if (el.isEmpty() == false) {
			for (Object[] o : el) {
				System.out.println("Employee Name : "+o[0]);
				System.out.println("Employee sal : "+o[1]);
				System.out.println("-----------------------");
			}
		} else {
			System.out.println("No Employee present in the Given Salary Range");
		}
	}
}
