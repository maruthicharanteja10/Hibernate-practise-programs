package org.jspmanytomanyuni_controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytomanyuni_dto.Student;

public class _09_FindStudentByName {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Name of student to get studemt details");
		String name = s.next();
		String qry = "select s from Student s where s.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		List<Student> stu = q.getResultList();
		if (stu.size() > 0) {
			for (Student st : stu) {
				System.out.println("ID :" + st.getId());
				System.out.println("Name:" + st.getName());
				System.out.println("Percentage :" + st.getPerc());
				System.out.println("Phone number :" + st.getPhone());
			}
		}

	}
}
