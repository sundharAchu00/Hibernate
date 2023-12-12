package edu.jsp.employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeCrud {
	static Scanner sc = new Scanner(System.in);
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();

	public static void main(String[] args) {

		boolean b = true;
		do {
			System.out.println("\t\t\tEmployee CRUD");
			System.out.println("1.Insert Employees Details");
			System.out.println("2.Update Employees Details");
			System.out.println("3.Delete Employees Details");
			System.out.println("4.Employee details based on ID");
			System.out.println("5.Exit");

			switch (sc.nextInt()) {
			case 1: {
				Employee e = new Employee();
				et.begin();
				System.out.println("Enter Employee ID :");
				e.setId(sc.nextInt());
				System.out.println("Enter Employee Name :");
				e.setName(sc.next());
				System.out.println("Enter Employee phone number :");
				e.setPhone_number(sc.nextLong());
				System.out.println("Enter Employee Salary : ");
				e.setSal(sc.nextDouble());
				em.persist(e);
				et.commit();
				System.out.println("Data Inserted Successfully...");
				break;
			}
			case 2: {
				boolean b1 = true;
				System.out.println("Enter Employee ID");
				Employee e = em.find(Employee.class, sc.nextInt());
				do {
					if (e != null) {
						System.out.println("\t\tWhich Details Do You Want To Update");
						System.out.println("1.ID ");
						System.out.println("2.Name ");
						System.out.println("3.Phone Number ");
						System.out.println("4.Salary ");
						System.out.println("5.Exit ");
						switch (sc.nextInt()) {
						case 1: {

							System.out.println("Enter New Employee ID ");
							e.setId(sc.nextInt());
							break;
						}
						case 2: {

							System.out.println("Enter Correct Employee Name ");
							e.setName(sc.next());

							break;
						}
						case 3: {

							System.out.println("Enter Correct Employee Phone_Number");
							e.setPhone_number(sc.nextLong());
							break;
						}
						case 4: {
							System.out.println("Enter Revised Employee Salary");
							e.setSal(sc.nextDouble());
							break;
						}
						case 5: {
							b1 = false;
							et.begin();
							em.persist(e);
							et.commit();
							System.out.println("Employee data updated Successfully...");
							System.out.println("-------------------------");
							break;
						}
						default:
							System.out.println("Select With In The Range");
							break;
						}
					} else {
						System.out.println("Enter Employee ID Data Not Found...");
					}
				} while (b1);
				break;
			}

			// --------------------------------------------
			case 3: {
				System.out.println("Enter Employee ID");
				Employee e = em.find(Employee.class, sc.nextInt());
				if (e != null) {
					et.begin();
					em.remove(e);
					et.commit();
					System.out.println("Data Deleted Successfully...");
				} else {
					System.out.println("Entered Employee ID Not Found in the database");
				}
				break;
			}
			case 4: {
				System.out.println("Enter Employee ID ");
				Employee e = em.find(Employee.class, sc.nextInt());
				if (e != null) {
					System.out.println("---------------------------");
					System.out.println(e);
				} else {
					System.out.println("Data Not Found");
				}
				break;
			}
			case 5: {
				b = false;
				System.out.println("Thank You Updating Employee Details..");
				System.out.println("--------------------------");
				break;
			}
			default: {
				System.out.println("Select With In The Range");
				break;
			}
			}
		} while (b);
	}
}
