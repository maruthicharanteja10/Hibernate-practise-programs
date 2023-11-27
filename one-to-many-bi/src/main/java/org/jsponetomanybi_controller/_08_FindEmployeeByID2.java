package org.jsponetomanybi_controller;

import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetomanybi_dto.Employee;

public class _08_FindEmployeeByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Employee Id to get employee details");
		int id = s.nextInt();
		String qry = "select e from Employee e where e.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Employee e = (Employee) q.getSingleResult();
			System.out.println("ID :" + e.getId());
			System.out.println("Name :" + e.getName());
			System.out.println("Designation :" + e.getDesgn());
			System.out.println("Salary :" + e.getSalary());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid ID");
		}
	}
}
