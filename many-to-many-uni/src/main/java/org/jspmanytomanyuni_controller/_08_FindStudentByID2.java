package org.jspmanytomanyuni_controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytomanyuni_dto.Student;
public class _08_FindStudentByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Student ID to get the Student Details");
		int id = s.nextInt();
		String qry = "select s from Student s where s.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			Student st = (Student) q.getSingleResult();
			System.out.println("ID :" + st.getId());
			System.out.println("Name:" + st.getName());
			System.out.println("Percentage :" + st.getPerc());
			System.out.println("Phone number :" + st.getPhone());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid ID");
		}
	}
}
