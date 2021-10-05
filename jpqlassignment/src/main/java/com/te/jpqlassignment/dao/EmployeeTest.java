package com.te.jpqlassignment.dao;

import java.util.Scanner;

public class EmployeeTest {
	public static void main(String[] args) {
		EmployeeMain employeeMain = new EmployeeMain();
		String value = null;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Press 1 to fetch all the records");
			System.out.println("Press 2 to fetch any particular record");
			System.out.println("Press 3 to update any particular record");
			System.out.println("Press 4 to delete a record");
			System.out.println("Enter the option:");
			int option = scanner.nextInt();
			switch (option) {
			case 1:	employeeMain.findAll();
			break;
			case 2:	employeeMain.findParticular();
			break;
//			case 3:	employeeMain.update();
//			break;
			case 3:	employeeMain.updateParticular();
			break;
			case 4:	employeeMain.deleteParticular();
			break;
			default: throw new InvalidOptionException("Please enter the correct option!!!");
			}
			System.out.println("Do you want more? (yes/no)");
			value = scanner.next();
		} while (value.equalsIgnoreCase("yes"));
	}
}
