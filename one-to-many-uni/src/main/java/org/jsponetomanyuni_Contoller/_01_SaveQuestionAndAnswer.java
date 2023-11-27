package org.jsponetomanyuni_Contoller;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsponetomanyuni_dto.AnswerData;
import org.jsponetomanyuni_dto.QuestionData;

public class _01_SaveQuestionAndAnswer {
	public static void main(String[] args) {
		QuestionData q = new QuestionData();
		q.setQuestion("What is jdbc");
		q.setQuestionedBy("kohli");

		AnswerData a1 = new AnswerData();
		a1.setAnswer("jdbc is used to connect java application to mysql");
		a1.setAnsweredBy("tej");
		AnswerData a2 = new AnswerData();
		a2.setAnswer("jdbc has 5 steps to connect");
		a2.setAnsweredBy("Joshna");
		AnswerData a3 = new AnswerData();
		a3.setAnswer("jdbc is comes under J2EE");
		a3.setAnsweredBy("charan");
		List<AnswerData> answers = new ArrayList<AnswerData>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);
		q.setAnswers(answers);
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(q);
		transaction.begin();
		transaction.commit();

	}
}
