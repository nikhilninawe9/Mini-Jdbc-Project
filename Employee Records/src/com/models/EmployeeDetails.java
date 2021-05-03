package com.models;

import java.util.Scanner;

public class EmployeeDetails {

	public static void main(String[] args) {

		int employee_id, n;
		String employee_name;
		int employee_salary;
		String employee_job;
		boolean x = false;

		do {
			System.out.println("*********************************************");
			System.out.println("Press 1 to Select particular employee record");
			System.out.println("Press 2 to Insert particular employee record");
			System.out.println("Press 3 to Delete particular employee record");
			System.out.println("Press 4 to Update particular employee record");
			System.out.println("Press 5 to Select All employee record");
			System.out.println("Please enter the option");
			System.out.println("*********************************************");
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();

			switch (n) {
			case 1:
				System.out.println("------------------------------------------");
				System.out.println("Welcome to the Employee Records System");
				System.out.println("------------------------------------------");
				System.out.println("Please enter employee id to see the record");
				employee_id = sc.nextInt();
				try {
					new GetEmployeesById(employee_id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				x = true;
				break;

			case 2:
				System.out.println("------------------------------------------");
				System.out.println("Welcome to the Employee Records System");
				System.out.println("------------------------------------------");
				System.out.println("Please enter employee id to add the record");
				employee_id = sc.nextInt();
				System.out.println("Please enter employee name");
				employee_name = sc.next();
				System.out.println("Please enter employee job");
				employee_job = sc.next();
				System.out.println("Please enter employee salary");
				employee_salary = sc.nextInt();
				new AddEmployees(employee_id, employee_name, employee_job, employee_salary);
				x = true;
				break;

			case 3:
				System.out.println("------------------------------------------");
				System.out.println("Welcome to the Employee Records System");
				System.out.println("------------------------------------------");
				System.out.println("Please enter employee id to delete the record");
				employee_id = sc.nextInt();
				new DeleteEmployee(employee_id);
				x = true;
				break;

			case 4:
				System.out.println("------------------------------------------");
				System.out.println("Welcome to the Employee Records System");
				System.out.println("------------------------------------------");
				System.out.println("Please enter employee name to update the record");
				employee_name = sc.next();
				System.out.println("Please enter employee job");
				employee_job = sc.next();
				System.out.println("Please enter employee salary");
				employee_salary = sc.nextInt();
				System.out.println("Please enter employee id");
				employee_id = sc.nextInt();
				new UpdateEmployee(employee_name, employee_job, employee_salary, employee_id);
				x = true;
				break;

			case 5:
				System.out.println("List of employees are as follows...");
				new GetAllEmployees();
				x = true;
				break;

			default:
				System.out.println("***************Wrong choice!*****************");
				x = true;
				break;
			}
		} while (x != false);
	}

}
