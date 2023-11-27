package org.jsp.employeeapp.controller;

import java.util.Scanner;
import org.jsp.employeeapp.impl.EmployeeImpl;
import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeController {
	static EmployeeImpl e = new EmployeeImpl();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.Delete Employee By Id");
		System.out.println("5.verify Employee By Id and password");
		System.out.println("6.verify Employee By phone and password");
		System.out.println("7.verify Employee By email and password");
		int choice = s.nextInt();
		switch (choice) {
		case 1: {
			e.save();
			break;
		}
		case 2: {
			e.update();
			break;
		}
		case 3: {
			e.findById();
			break;
		}
		case 4: {
			e.delete();
			break;
		}
		case 5: {
			e.verifyById();
			break;
		}
		case 6: {
			e.verifyByPhone();
			break;
		}
		case 7: {
			e.verifyByEmail();
			break;
		}
		default: {
			System.err.println("Invalid Choice");
		}
		}
	}

}