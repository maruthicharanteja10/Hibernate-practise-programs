package org.jsponetomanybi_controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsponetomanybi_dto.Employee;

public class _07_FindEmployeeByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Employee Id to get employee details");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Employee e = manager.find(Employee.class, id);
		if (e != null) {
			System.out.println("ID :" + e.getId());
			System.out.println("Name :" + e.getName());
			System.out.println("Designation :" + e.getDesgn());
			System.out.println("Salary :" + e.getSalary());
		} else {
			System.err.println("You have entered an invalid ID");
		}
	}
}
