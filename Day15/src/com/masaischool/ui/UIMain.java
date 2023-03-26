package com.masaischool.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masaischool.dao.MobileDAO;
import com.masaischool.dao.MobileDAOImpl;
import com.masaischool.dto.Mobile;
import com.masaischool.dto.MobileImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class UIMain {
	
	static void addMobileUI(Scanner sc) {
		//take input employee details
		System.out.print("Enter model no ");
		String model_no = sc.next();
		
		System.out.print("Enter company name ");
		String company = sc.next();
		
		System.out.print("Enter Price ");
		int price = sc.nextInt();
		
		System.out.print("Enter MFG date ");
		LocalDate mfgdate = LocalDate.parse(sc.next());
		
		//Create an object of DTO
		Mobile mobile = new MobileImpl(model_no, company, price, mfgdate);
		
		MobileDAO mbDAO = new MobileDAOImpl();
		
		try {
			mbDAO.addMobile(mobile);	
			System.out.println("Mobile added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}
	
	static void updateMobileUI(Scanner sc) {
		//take input employee details
		System.out.print("Enter model no ");
		String model_no = sc.next();
		
		System.out.print("Enter company name ");
		String company = sc.next();
		
		System.out.print("Enter Price ");
		int price = sc.nextInt();
		
		System.out.print("Enter MFG date ");
		LocalDate mfgdate = LocalDate.parse(sc.next());
		
		//Create an object of DTO
		Mobile mobile = new MobileImpl(model_no, company, price, mfgdate);
		
				//take an object of DAO
		MobileDAO mbDAO = new MobileDAOImpl();
		
		try {
			//call the update employee method
			mbDAO.updateMobile(mobile);
			//print success message
			System.out.println("Mobile updated successfully");
		}catch(SomethingWentWrongException ex) {
			//print error message if error if there
			System.out.println(ex);
		}
	}
	
	static void deleteMobileUI(Scanner sc) {
		System.out.print("Enter Model No ");
		String model_no = sc.next();
		
		//take an object of DAO
		MobileDAO mbDAO = new MobileDAOImpl();
		
		try {
			//call the update employee method
			mbDAO.deleteMobile(model_no);
			//print success message
			System.out.println("Mobile deleted successfully");
		}catch(SomethingWentWrongException ex) {
			//print error message if error if there
			System.out.println(ex);
		}
	}
	
	static void viewMobile() {
		//take an object of DAO
		MobileDAO mbDAO = new MobileDAOImpl();
		try {
			List<Mobile> mbList = mbDAO.getMobileList();
			Consumer<Mobile> con = mb -> System.out.println("Model_NO " + mb.getModel_no() + " Company " + mb.getCompany() 
			+ " Price " + mb.getPrice() + " mfg Date " + mb.getMfgdate());
			mbList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void searchMobileByModelNo(Scanner sc) {
		System.out.println("Enter model no");
		String model_no = sc.next();
		//take an object of DAO
		MobileDAO mbDAO = new MobileDAOImpl();
		try {
			List<Mobile> mbList = mbDAO.searchMobileByModelNo(model_no);
			Consumer<Mobile> con = mb -> System.out.println("Model_NO " + mb.getModel_no() + " Company " + mb.getCompany() 
			+ " Price " + mb.getPrice() + " mfg Date " + mb.getMfgdate());
			mbList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	static void searchMobileByPriceRange(Scanner sc) {
		System.out.println("Enter Minimum price");
		int price1 = sc.nextInt();
		System.out.println("Enter Maximum price");
		int price2 = sc.nextInt();
		//take an object of DAO
		MobileDAO mbDAO = new MobileDAOImpl();
		try {
			List<Mobile> mbList = mbDAO.searchMobileByPriceRange(price1,price2);
			Consumer<Mobile> con = mb -> System.out.println("Model_NO " + mb.getModel_no() + " Company " + mb.getCompany() 
			+ " Price " + mb.getPrice() + " mfg Date " + mb.getMfgdate());
			mbList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
		
		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Mobile");
			System.out.println("2. Update MobileInfo using model_no of mobile");
			System.out.println("3. Delete Mobile using model_no of mobile");
			System.out.println("4. View All Mobile");
			System.out.println("5. Search Mobile By Model No");
			System.out.println("6. Search Mobile By Price Range");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				addMobileUI(sc);
				break;
			case 2:
				updateMobileUI(sc);
				break;
			case 3:
				deleteMobileUI(sc);
				break;
			case 4:
				viewMobile();
				break;
			case 5:
				searchMobileByModelNo(sc);
				break;
			case 6:
				searchMobileByPriceRange(sc);
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
