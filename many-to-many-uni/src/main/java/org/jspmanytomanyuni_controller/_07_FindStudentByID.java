package org.jspmanytomanyuni_controller;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jspmanytomanyuni_dto.Student;
public class _07_FindStudentByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Student ID to get the Student Details");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Student st = manager.find(Student.class, id);
		if (st != null) {
			System.out.println("ID :" + st.getId());
			System.out.println("Name:" + st.getName());
			System.out.println("Percentage :" + st.getPerc());
			System.out.println("Phone number :" + st.getPhone());
		} else {
			System.err.println("You have entered an invalid ID");
		}
	}
}


