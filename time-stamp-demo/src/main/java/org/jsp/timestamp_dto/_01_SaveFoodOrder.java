package org.jsp.timestamp_dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.timestamp_Controller.FoodOrder;

public class _01_SaveFoodOrder {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = new FoodOrder();
		order.setAddress("electronic city");
		order.setFood_item("chicken 65");
		order.setCost(200);
		manager.persist(order);
		transaction.begin();
		transaction.commit();
		System.out.println("Accepted ordered succesfully");
	}
}
