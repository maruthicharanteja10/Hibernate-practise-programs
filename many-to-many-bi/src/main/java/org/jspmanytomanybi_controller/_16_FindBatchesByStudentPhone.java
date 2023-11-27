package org.jspmanytomanybi_controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspmanytomanybi_dto.Batch;

public class _16_FindBatchesByStudentPhone {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the student phone to find batch details");
		long phone = s.nextLong();
		String qry = "select s.batches from Student s where s.phone=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		List<Batch> bt = q.getResultList();
		if (bt.size() > 0) {
			for (Batch b : bt) {

				System.out.println("ID:" + b.getId());
				System.out.println("Subject :" + b.getSubject());
				System.out.println("Batchcode:" + b.getBatch_code());
				System.out.println("Trainer :" + b.getTrainer());
			}
		} else {
			System.err.println("You have entered an invalid studentID");
		}
	}
}
