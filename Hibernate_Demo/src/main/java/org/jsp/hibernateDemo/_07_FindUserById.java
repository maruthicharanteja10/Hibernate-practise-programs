package org.jsp.hibernateDemo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class _07_FindUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Id to display details");
		int id = sc.nextInt();
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		User u = s.get(User.class, id);
		if (u != null) {
			System.out.println("UserId:" + u.getId());
			System.out.println("Name :" + u.getName());
			System.out.println("PhoneNumber:" + u.getPhone());
			System.out.println("Email Id:  " + u.getEmail());
		} else {
			System.err.println("You have entered an Invalid Id");
		}
	}
}
