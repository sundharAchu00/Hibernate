package edu.jsp.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Override
	public String toString() {
		return "Employee : \n   id=" + id + ",\n name=" + name + ",\n sal=" + sal + ",\n phone_number=" + phone_number;
	}

	@Id
	private int id;
	private String name;
	private double sal;
	private long phone_number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

}
