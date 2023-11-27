package org.jsponetoonebi_Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetoonebi_dto.Person;

public class _09_FindPersonByPancardNumber {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Pancard number");
		long pannum=s.nextLong();
		String qry="select p from Person p where p.card.number=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q=manager.createQuery(qry);
		q.setParameter(1, pannum);
		if(q!=null) {
			Person p=(Person) q.getSingleResult();
			System.out.println("person ID:" + p.getId());
			System.out.println("Name :" + p.getEmail());
			System.out.println("Phone :" + p.getPhone());
			System.out.println("Email :" + p.getEmail());
		}
		else {
			System.err.println("you have entered an invalid pancard number");
		}
	}
}
