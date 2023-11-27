package org.jspmanytomanyuni_controller;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jspmanytomanyuni_dto.Batch;

public class _04_FindBatchByBatch_Code {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the batch code to get the Batch details");
		String batchcode = s.next();
		String qry = "select b from Batch b where b.batch_code=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, batchcode);
		try {
			Batch b = (Batch) q.getSingleResult();
			System.out.println("ID :" + b.getId());
			System.out.println("Subject :" + b.getSubject());
			System.out.println("Batch Code :" + b.getBatch_code());
			System.out.println("Trainer :" + b.getTrainer());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid batch code");
		}
	}
}
