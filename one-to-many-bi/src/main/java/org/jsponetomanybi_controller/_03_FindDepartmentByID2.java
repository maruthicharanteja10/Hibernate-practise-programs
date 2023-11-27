package org.jsponetomanybi_controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetomanybi_dto.Department;

public class _03_FindDepartmentByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Department Id to get the departement details");
		int id = s.nextInt();
		String qry = "select d from Department d where d.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Department d = (Department) q.getSingleResult();
			System.out.println("ID :" + d.getId());
			System.out.println("Name :" + d.getName());
			System.out.println("Location :" + d.getLocation());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid ID");
		}
	}
}
