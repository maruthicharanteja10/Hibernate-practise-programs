package org.jspmanytomanyuni_controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytomanyuni_dto.Student;

public class _13_FindStudentByBatch_ID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the batch ID to get the student details");
		int id = s.nextInt();
		String qry = "select b.students from Batch b where b.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		List<Student> stu=q.getResultList();
		if (stu.size() > 0) {
			for (Student st : stu) {
				System.out.println("ID :" + st.getId());
				System.out.println("Name:" + st.getName());
				System.out.println("Percentage :" + st.getPerc());
				System.out.println("Phone number :" + st.getPhone());
				System.out.println("----------------------");
			}
		}
		
		else {
			System.err.println("You have enetered an invalid ID");
		}
	}
}
