package com.masaischool.ui;

import java.util.List;
import java.util.Scanner;

import com.masaischool.dao.DepartmentDAO;
import com.masaischool.dao.DepartmentDAOImpl;
import com.masaischool.dao.EmployeeDAO;
import com.masaischool.dao.EmployeeDAOImpl;
import com.masaischool.dto.Department;
import com.masaischool.dto.DepartmentImpl;
import com.masaischool.dto.Employee;
import com.masaischool.dto.EmployeeImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class UIMain {
	
	
	static void addEmployeeUI(Scanner sc) {
		//take input employee details
		
		System.out.print("Enter Employee name ");
		String ename = sc.next();
		
		System.out.print("Enter Address ");
		String address = sc.next();
		
		System.out.print("Enter Mobile ");
		String mobile = sc.next();
		
		System.out.print("Enter dept Id ");
		int deptid = sc.nextInt();
		
		//Create an object of DTO
		Employee employee = new EmployeeImpl(ename, address, mobile, deptid);
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			empDAO.addEmployee(employee);	
			System.out.println("Employee Details added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}
	
	static void addDepartmentUI(Scanner sc) {
		//take input employee details
		
		System.out.print("Enter Department name ");
		String dname = sc.next();
		
		System.out.print("Enter Location ");
		String location = sc.next();
		
		
		//Create an object of DTO
		Department department = new DepartmentImpl(dname,location);
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			deptDAO.addDepartment(department);	
			System.out.println("Department details added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}
	
	static void viewEmployeeDetails(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
		System.out.print("Enter Department name ");
		String dname = sc.next();
		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try {
			List<Employee> list = employeeDAO.getEmployeeDetails(dname);
			list.forEach(System.out::println);
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	static void viewEmployeeDetailsbyAddress() throws SomethingWentWrongException, NoRecordFoundException {
//		System.out.print("Enter employee Address ");
//		String address = sc.next();
		
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		try {
			List<Department> list = departmentDAO.getDapartmentDetails();
			list.forEach(System.out::println);
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	static void deleteDepartmentUI(Scanner sc) {
		System.out.print("Enter Department name ");
		String dname = sc.next();
		
		//take an object of DAO
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		
		try {
			//call the update employee method
			departmentDAO.deleteDepartment(dname);
			//print success message
			System.out.println("Department deleted successfully");
		}catch(SomethingWentWrongException ex) {
			//print error message if error if there
			System.out.println(ex);
		}
	}
	public static void main(String[] args) throws SomethingWentWrongException, NoRecordFoundException {
		Scanner sc = new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Employee Details");
			System.out.println("2. Add Department details");
			System.out.println("3. Search Employee who work Account Department");
			System.out.println("4. Delete Department");
			System.out.println("5. Search Department who live in Mumbai");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				addEmployeeUI(sc);
				break;
			case 2:
				addDepartmentUI(sc);
				break;
			case 3:
				viewEmployeeDetails(sc);
				break;
			case 4:
				deleteDepartmentUI(sc);
				break;
			case 5:
				viewEmployeeDetailsbyAddress();
				break;
			case 0:
				System.out.println("Bye Bye");
				break;
			default:
				System.out.println("Invalid Selection please try again later");	
			}
			
		}while(choice !=0);
	}
}
