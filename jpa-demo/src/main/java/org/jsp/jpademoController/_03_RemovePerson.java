package org.jsp.jpademoController;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.jpademo.dto.Person;

public class _03_RemovePerson {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to remove");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			manager.remove(p);
			System.out.println("Person deleted");
			transaction.begin();
			transaction.commit();
			System.out.println("Removed Succesfully");
		} else {
			System.out.println("cannot delete person!!! As the id is Invalid");
		}
	}
}
