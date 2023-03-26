package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.UserLoggedIn;

public class UIMain {
	
	
	static void updateTask(Scanner sc) {
		
		int choice =0;
		do {
			System.out.println("1. Update Task Name ");
			System.out.println("2. Change Start and End Date ");
			System.out.println("0. Exit");
			System.out.print("Enter Right Selection ");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				TaskUI.updateTaskName(sc);
				break;
			case 2:
				TaskUI.changeStartAndEndTime(sc);
				break;
			case 0:
				break;
			default:
				System.out.println("Kindly the right input.");
				
			}
			
		}while(choice!=0);
	}
	static void displayUserMenu() {
		System.out.println("1. Add Task");
		System.out.println("2. Update Task");
		System.out.println("3. Make it Done");
		System.out.println("4. View All Tasks");
		System.out.println("5. View Pending Tasks");
		System.out.println("6. View Task between Date Range");
		System.out.println("0. Logout");
	}
	
	static void userLogin(Scanner sc ) {
		if(!UserUI.login(sc)) 
			return;
		
		
		int choice =0;
		do {
		displayUserMenu();
		System.out.print("Enter the Selection ");
		choice = Integer.parseInt(sc.nextLine());
		
		switch(choice) {
        case 1:
        	  TaskUI.addTask(sc);
        	  break;
        case 2:
        	updateTask(sc);
      	    break;
        case 3: 
        	TaskUI.makeItDone(sc);
      	     break;
        case 4:
        	TaskUI.viewAllTasks();
        	 break;
        case 5:
        	TaskUI.viewPendingTask();
      	    break;
        case 6:
        	TaskUI.viewTaskbetweenDateRange(sc);
      	     break;
        case 0:
        	 UserUI.logOut();
        	  break;
        default:
        	System.out.println("Invalid Input.");
         
        }
		}while(choice!=0);
	
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice=0;
		System.out.println("Welcome to Todo List Applicaton.");
		do {
			
			System.out.println("1. Singup");
			System.out.println("2. Login");
			System.out.println("0. Exit");
			System.out.print("Enter Your Choice ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1: 
				UserUI.signUp(sc);
				break;
			case 2: 
				userLogin(sc);
				break;
			case 0:
				System.out.println("Thank you for Using");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}while(choice!=0);
		sc.close();
		
		
	}
	

}
