package org.jsponetomanybi_controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetomanybi_dto.Employee;

public class _10_FindEmployeeWhoseSalaryGreaterThan5000 {
	public static void main(String[] args) {

		String qry = "select e from Employee e where e.salary>5000";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		List<Employee> em = q.getResultList();
		if (em.size() > 0) {
			for (Employee e : em) {
				System.out.println("ID :" + e.getId());
				System.out.println("Name :" + e.getName());
				System.out.println("Designation :" + e.getDesgn());
				System.out.println("Salary :" + e.getSalary());
				System.out.println("-------------------------");
			}
		} else {
			System.err.println("You have entered an invalid salary");
		}
	}
}
