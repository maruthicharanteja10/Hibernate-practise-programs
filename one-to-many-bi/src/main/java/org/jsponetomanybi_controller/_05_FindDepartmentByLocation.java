package org.jsponetomanybi_controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetomanybi_dto.Department;

public class _05_FindDepartmentByLocation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Location to get the departement details");
		String location = s.nextLine();
		String qry = "select d from Department d where d.location=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, location);
		List<Department> ds = q.getResultList();
		if (ds.size() > 0) {
			for (Department d : ds) {
				System.out.println("ID :" + d.getId());
				System.out.println("Name :" + d.getName());
				System.out.println("Location :" + d.getLocation());
			}
		} else {
			System.err.println("You have entered an invalid location");
		}
	}
}
