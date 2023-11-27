package org.jsp.Embeddable_contoller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Embeddable_dto.User;

public class DeleteUserByEmail {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Email to delete the User details");
		String email = s.next();
		String qry="delete from User u where u.id.email=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Query q=manager.createQuery(qry);
		q.setParameter(1, email);
//		User uu = manager.find(User.class, email);
//		manager.remove(uu);
	try {
		User u=(User) q.getSingleResult();
		System.out.println("user removed succesfully");
		transaction.begin();
		transaction.commit();
	}
	catch(NoResultException e) {
		
	}
		
		
	}
}
