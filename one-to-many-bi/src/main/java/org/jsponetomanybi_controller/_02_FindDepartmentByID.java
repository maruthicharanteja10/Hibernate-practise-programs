package org.jsponetomanybi_controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsponetomanybi_dto.Department;
public class _02_FindDepartmentByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Department Id to get the departement details");
		int id=s.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Department d=manager.find(Department.class, id);
		if(d!=null) {
			System.out.println("ID :"+d.getId());
			System.out.println("Name :"+d.getName());
			System.out.println("Location :"+d.getLocation());
			}
		else {
			System.err.println("You have entered an invalid ID");
		}
	}
}
