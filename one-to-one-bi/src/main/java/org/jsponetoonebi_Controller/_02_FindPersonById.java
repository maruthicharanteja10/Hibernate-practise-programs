package org.jsponetoonebi_Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsponetoonebi_dto.Person;

public class _02_FindPersonById {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter  id");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			System.out.println("person ID:" + p.getId());
			System.out.println("Name :" + p.getName());
			System.out.println("Phone :" + p.getPhone());
			System.out.println("Email :" + p.getEmail());
		} else {
			System.err.println("You have Entered an Invalid ID");
		}
	}
}
