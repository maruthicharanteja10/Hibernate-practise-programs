package org.jsponetomanybi_controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetomanybi_dto.Department;

public class _04_FindDepartmentByName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Name to get the departement details");
		String name = s.next();
		String qry = "select d from Department d where d.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Department> ds = q.getResultList();
		if (ds.size() > 0) {
			for (Department d : ds) {
				System.out.println("ID :" + d.getId());
				System.out.println("Name :" + d.getName());
				System.out.println("Location :" + d.getLocation());
			}
		} else {
			System.err.println("You have entered an invalid Name");
		}
	}
}
