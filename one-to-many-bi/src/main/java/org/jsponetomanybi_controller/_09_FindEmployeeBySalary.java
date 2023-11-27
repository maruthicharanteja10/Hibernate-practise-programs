package org.jsponetomanybi_controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetomanybi_dto.Employee;

public class _09_FindEmployeeBySalary {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the employee salary to get the details");
		double salary = s.nextDouble();
		String qry = "select e from Employee e where e.salary=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, salary);
		List<Employee> em = q.getResultList();
		if (em.size() > 0) {
			for (Employee e : em) {
				System.out.println("ID :" + e.getId());
				System.out.println("Name :" + e.getName());
				System.out.println("Designation :" + e.getDesgn());
				System.out.println("Salary :" + e.getSalary());
			}
		} else {
			System.err.println("You have entered an invalid salary");
		}
	}
}
