package org.jspmanytomanyuni_controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytomanyuni_dto.Student;

public class _11_FindStudentWhosePercIsLesserThan35 {
	public static void main(String[] args) {
		String qry = "select s from Student s where s.perc<35";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		List<Student> stu = q.getResultList();
		if (stu.size() > 0) {
			for (Student st : stu) {
				System.out.println("ID :" + st.getId());
				System.out.println("Name:" + st.getName());
				System.out.println("Percentage :" + st.getPerc());
				System.out.println("Phone number :" + st.getPhone());
				System.out.println("----------------------------");
			}
		}
	}
}
