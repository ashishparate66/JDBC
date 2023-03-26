package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.UserDao;
import com.masai.dao.UserDaoImpl;
import com.masai.dto.UserDTO;
import com.masai.exceptions.SomethingWentWrongException;

public class UserUI {
	
	static void signUp(Scanner sc) {
		System.out.print("Enter the Name of the User");
		String name = sc.nextLine();
		
		System.out.print("Enter the Username ");
		String userName = sc.nextLine();
		
		System.out.print("Enter the Password");
		String password = sc.nextLine();
		
		UserDTO udto = new UserDTO(name, userName, password);
	
		UserDao udao = new UserDaoImpl();
		udao.signUp(udto);

	}
	
	static boolean login(Scanner sc){
		System.out.print("Enter the username ");
		String username = sc.nextLine();
		System.out.print("Enter the password ");
		String password = sc.nextLine();
		
		UserDao udao = new UserDaoImpl();
		try {
			udao.login(username, password);
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	static void logOut() {
		UserDao udao = new UserDaoImpl();
		udao.signOut();
	}

}
