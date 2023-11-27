package org.jsp.Embeddable_contoller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsp.Embeddable_dto.User;
import org.jsp.Embeddable_dto.UserID;

public class _02_FindUserByEmailAndPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		System.out.println("Enter the Email and Phone");
		UserID id = new UserID();
		id.setEmail(sc.next());
		id.setPhone(sc.nextLong());
		User u = manager.find(User.class, id);
		if (u != null) {
			System.out.println("Name :" + u.getName());
			System.out.println("Age :" + u.getAge());
			System.out.println("Phone number: " + u.getId().getPhone());
			System.out.println("Email: " + u.getId().getEmail());
		} else {
			System.err.println("Invalid EmailID (or) Phone");
		}
	}
}