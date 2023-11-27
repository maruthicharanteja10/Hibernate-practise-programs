package org.jspmanytooneuni_Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jspmanytooneuni_dto.Branch;
import org.jspmanytooneuni_dto.Hospital;

public class _01_SaveHospitalAndBranch {
	public static void main(String[] args) {
		Hospital h = new Hospital();
		h.setFounder("virat");
		h.setName("kohli");
		h.setYear_of_estb(2002);
		Branch b1 = new Branch();
		b1.setName("kohli kadapa");
		b1.setEmail("kohliKpd@gmail.com");
		b1.setPhone(898988);
		b1.setCity("kadapa");
		b1.setHospital(h);
		Branch b2 = new Branch();
		b2.setName("kohli proddatur");
		b2.setEmail("kohlipdtr@gmail.com");
		b2.setPhone(7377578);
		b2.setCity("proddatur");
		b2.setHospital(h);
		Branch b3 = new Branch();
		b3.setName("kohli pulivendula");
		b3.setEmail("kohliplvd@gmail.com");
		b3.setPhone(8967899);
		b3.setCity("pulivendula");
		b3.setHospital(h);
		EntityManager manager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.begin();
		transaction.commit();
		System.out.println("Inserted successfully");
	}
}
