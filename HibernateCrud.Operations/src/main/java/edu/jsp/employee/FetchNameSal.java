package edu.jsp.employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchNameSal {
	public static void main(String[] args) {
		EntityManagerFactory emf  = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("select e.name,e.sal from Employee e");
		
		List< Object[]> list = q.getResultList();
		System.out.println(list);
//		int i=0;
		for (Object[] o : list) {
			System.out.println("name :"+ o[0]);
			System.out.println("sal :"+ o[1]);
		}
	}
}
