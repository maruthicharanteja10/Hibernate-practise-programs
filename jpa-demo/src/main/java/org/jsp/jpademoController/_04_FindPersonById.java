package org.jsp.jpademoController;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.jpademo.dto.Person;

public class _04_FindPersonById {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the person id to display details");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			System.out.println("Person Id:" + p.getId());
			System.out.println("Name :" + p.getName());
			System.out.println("Phone number:" + p.getPhone());
			System.out.println("Email Id:" + p.getEmail());
			System.out.println("Gender:" + p.getGender());
			System.out.println("Age:" + p.getAge());
		} else {
			System.err.println("You have entered an invalid Id");
		}
	}
}
