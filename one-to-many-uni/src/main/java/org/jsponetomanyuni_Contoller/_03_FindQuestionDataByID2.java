package org.jsponetomanyuni_Contoller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.jsponetomanyuni_dto.QuestionData;

public class _03_FindQuestionDataByID2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id for the questiondata");
		int id = s.nextInt();
		String qry = "select q from QuestionData q where q.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			QuestionData qd = (QuestionData) q.getSingleResult();
			System.out.println("Question ID :" + qd.getId());
			System.out.println("Question :" + qd.getQuestion());
			System.out.println("QuestionBy  :" + qd.getQuestionedBy());
		} catch (NoResultException e) {
			System.err.println("You have entered an invalid id ");
		}
	}
}
