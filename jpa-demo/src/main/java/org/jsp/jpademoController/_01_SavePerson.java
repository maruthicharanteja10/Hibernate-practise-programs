package org.jsp.jpademoController;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.jpademo.dto.Person;

public class _01_SavePerson {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter Name,Age,Email,Gender and Phoneno");
		String name=s.next();
		int age=s.nextInt();
		String email=s.next();
		String gender=s.next();
		Long phone=s.nextLong();
		p.setName(name);
		p.setAge(age);
		p.setEmail(email);
		p.setGender(gender);
		p.setPhone(phone);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA");
		EntityManager manager = factory.createEntityManager();
		manager.persist(p);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Person saved with id " + p.getId());
	}
}
