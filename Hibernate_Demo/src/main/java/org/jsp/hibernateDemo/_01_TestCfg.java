package org.jsp.hibernateDemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class _01_TestCfg {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		System.out.println(factory);
		
	}
}
