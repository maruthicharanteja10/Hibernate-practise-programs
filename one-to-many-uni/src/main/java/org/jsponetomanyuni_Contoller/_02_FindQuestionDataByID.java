package org.jsponetomanyuni_Contoller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.jsponetomanyuni_dto.QuestionData;

public class _02_FindQuestionDataByID {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the id for the questiondata");
		int id = s.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		QuestionData qd = manager.find(QuestionData.class, id);
		if(qd!=null) {
			System.out.println("Question ID :"+qd.getId());
			System.out.println("Question :"+qd.getQuestion());
			System.out.println("QuestionBy  :"+qd.getQuestionedBy());
		}
	}
}
