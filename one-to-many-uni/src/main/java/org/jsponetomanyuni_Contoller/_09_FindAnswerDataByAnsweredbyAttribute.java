package org.jsponetomanyuni_Contoller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsponetomanyuni_dto.AnswerData;

public class _09_FindAnswerDataByAnsweredbyAttribute {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the answeredby name for the answerdata ");
		String answeredby = s.next();
		String qry = "select a from AnswerData a where a.answeredBy=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, answeredby);
		try {
			AnswerData ad = (AnswerData) q.getSingleResult();
			System.out.println("Answer ID :" + ad.getId());
			System.out.println("Answer :" + ad.getAnswer());
			System.out.println("AnswerBy  :" + ad.getAnsweredBy(null));
		} catch (NoResultException e) {
			System.err.println("You have enetered an invalid answeredby name");
		}
	}
}
