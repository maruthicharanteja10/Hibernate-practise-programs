package org.jspmanytomanyuni_controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytomanyuni_dto.Student;

public class _12_FindStudentByPhone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Student phoneno to get the Student Details");
		Long phone = s.nextLong();
		String qry = "select s from Student s where s.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		try {
			Student st = (Student) q.getSingleResult();
			System.out.println("ID :" + st.getId());
			System.out.println("Name:" + st.getName());
			System.out.println("Percentage :" + st.getPerc());
			System.out.println("Phone number :" + st.getPhone());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid phone number");
		}

	}
}
