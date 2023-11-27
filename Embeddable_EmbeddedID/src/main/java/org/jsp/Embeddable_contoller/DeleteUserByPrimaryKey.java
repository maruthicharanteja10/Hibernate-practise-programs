package org.jsp.Embeddable_contoller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.Embeddable_dto.User;
import org.jsp.Embeddable_dto.UserID;

public class DeleteUserByPrimaryKey {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the primary key to delete the user");
		int id = sc.nextInt();
		
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
//	
//		UserID id = new UserID();
//		id.setEmail(sc.next());
//		id.setPhone(sc.nextLong());
	
		
		User u = manager.find(User.class, id);
	manager.remove(u);
		System.out.println("User removed succesfully");
	}
}
