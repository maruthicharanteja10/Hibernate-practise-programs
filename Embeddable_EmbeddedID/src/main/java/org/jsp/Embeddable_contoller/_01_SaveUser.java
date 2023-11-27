package org.jsp.Embeddable_contoller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.Embeddable_dto.User;
import org.jsp.Embeddable_dto.UserID;

public class _01_SaveUser {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		System.out.println("Enter the Email and Phone number");
		UserID id = new UserID();
		id.setEmail(s.next());
		id.setPhone(s.nextLong());
		System.out.println("Enter your name and age");
		User u = new User();
		u.setName(s.next());
		u.setAge(s.nextInt());
		u.setId(id);
		manager.persist(u);
		transaction.begin();
		transaction.commit();
		System.out.println("User saved successfully");
		s.close();
	}
}
