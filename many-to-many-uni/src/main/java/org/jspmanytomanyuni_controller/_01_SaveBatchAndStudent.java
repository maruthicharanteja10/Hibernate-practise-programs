package org.jspmanytomanyuni_controller;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jspmanytomanyuni_dto.*;
public class _01_SaveBatchAndStudent {
	public static void main(String[] args) {
		Batch b1 = new Batch();
		b1.setBatch_code("JBT-JFRHID-A1");
		b1.setSubject("Hibernate");
		b1.setTrainer("Satish");

		Batch b2 = new Batch();
		b2.setBatch_code("JBT-JFRCJD-M1");
		b2.setSubject("Core java");
		b2.setTrainer("Abhishek");

		Batch b3 = new Batch();
		b3.setBatch_code("JBT-JFRWTD-A1");
		b3.setSubject("Web technology");
		b3.setTrainer("Subhash");

		Student s1 = new Student();
		s1.setName("Tej");
		s1.setPerc(82);
		s1.setPhone(8653265765L);

		Student s2 = new Student();
		s2.setName("Charan");
		s2.setPerc(61);
		s2.setPhone(865885765L);

		Student s3 = new Student();
		s3.setName("jos");
		s3.setPerc(34);
		s3.setPhone(8433265765L);
		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2, s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1, s2)));
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();
		System.out.println("Inserted succesfully");

	}

}
