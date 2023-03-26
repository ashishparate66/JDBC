package com.problem1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Customer {
	
	static Connection getConnectionTodatabase() throws SQLException, ClassNotFoundException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		ResourceBundle rb = ResourceBundle.getBundle("dbdetails");
		return  DriverManager.getConnection(rb.getString("url"),rb.getString("username"), rb.getString("password"));
	     
		
	}
	static void closeConnection(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
		
	}
	
	
	static void addCustomer(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter Your Customer Id");
		String  customerId = sc.next();
		System.out.println("Please Enter Your Name");
		String  name = sc.next();
		System.out.println("Please Enter Your Gender");
		String  gender = sc.next();
		System.out.println("Please Enter Your Wallet Balance");
		double  walletBalance = sc.nextDouble();
		System.out.println("Please Enter Your Date of Joining");
		LocalDate date_of_joining = LocalDate.parse(sc.next());
		
		String query = "INSERT INTO CUSTOMER VALUES ('"+customerId+"', '"+name+"', '"+gender+"', "+walletBalance+" ,'"+date_of_joining+"')";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Customer added Successfully");
			System.out.println();
		}else {
			System.out.println("Not able to add Customer");
		}
		closeConnection(conn);
	}
	
	
	static void UpdateCustomer(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter Your Customer Id");
		String  customerId = sc.next();
		System.out.println("Please Enter Your Name");
		String  name = sc.next();
		System.out.println("Please Enter Your Gender");
		String  gender = sc.next();
		System.out.println("Please Enter Your Wallet Balance");
		double  walletBalance = sc.nextDouble();
		System.out.println("Please Enter Your Date of Joining");
		LocalDate date_of_joining = LocalDate.parse(sc.next());
		
		String query = "UPDATE CUSTOMER SET name = '"+name+"', gender = '"+gender+"', wallet_Balance = " + walletBalance +", date_of_joining = '"+date_of_joining+"' Where customerId = '"+customerId+"' ";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("Customer added Successfully");
			System.out.println();
		}else {
			System.out.println("Not able to add Customer");
		}
		closeConnection(conn);
	 }
	
	
		static void deleteCustomer(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		
		Statement st = conn.createStatement();
		
		String query = "DELETE FROM Customer where wallet_Balance = 0.00";
		int res =st.executeUpdate(query);
		
		if(res > 0) {
			System.out.println(res + " Customer delete Successfully");
			System.out.println();
		}else {
			System.out.println("Not able to add Customer");
		}
		closeConnection(conn);
	}
		
		static void viewCustomerList(Scanner sc) throws ClassNotFoundException, SQLException {
			
			Connection conn = getConnectionTodatabase();
			Statement st = conn.createStatement();
			String query = "select * from customer";
			ResultSet rs = st.executeQuery(query);
			
			if(!rs.isBeforeFirst() && rs.getRow()==0) {
				System.out.println("No Customer Found");
			}else {
				while(rs.next()) {
					System.out.println("CustomerId: " + rs.getString(1) + " Name: "+ rs.getString(2)+ " Gender: "+rs.getString(3)+ " Wallet_Balance: "+rs.getString(4)+ " date_of_joining: "+ rs.getString(5));
				}
			}
			closeConnection(conn);
		}
		
		static void searchCustomerByDate(Scanner sc) throws ClassNotFoundException, SQLException {
			
			Connection conn = getConnectionTodatabase();
			Statement st = conn.createStatement();
			
			System.out.println("Please Enter start Date");
			Date startDate = Date.valueOf(LocalDate.parse(sc.next()));
			
			System.out.println("Please Enter end Date");
			Date endDate = Date.valueOf(LocalDate.parse(sc.next()));
			
			String query = "select * from customer WHERE date_of_joining BETWEEN '"+startDate+"' AND '"+endDate+"';";
			ResultSet rs = st.executeQuery(query);
			
			if(!rs.isBeforeFirst() && rs.getRow()==0) {
				System.out.println("No Customer Found");
			}else {
				while(rs.next()) {
					System.out.println("CustomerId: " + rs.getString(1) + " Name: "+ rs.getString(2)+ " Gender: "+rs.getString(3)+ " Wallet_Balance: "+rs.getString(4)+ " date_of_joining: "+ rs.getString(5));
				}
			}
			closeConnection(conn);
		}
		
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
		Scanner sc = new Scanner(System.in);
		
		int choice =0;
		do {
			System.out.println("1 . Add Customers");
			System.out.println("2. Update Customers");
			System.out.println("3. Delete Customers");
			System.out.println("4. View List of Customers");
			System.out.println("5. Search customer by range of Date_of_Joining");
			System.out.println("0. EXIT");
			
			System.out.println("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addCustomer(sc);
					break;
				case 2:
					UpdateCustomer(sc);
					break;
				case 3:
					deleteCustomer(sc);
					break;
				case 4:
					viewCustomerList(sc);
					break;
				case 5:
					searchCustomerByDate(sc);
					break;
				case 0:
					System.out.println("Thanks for using our services");
					break;
				default:
					System.out.println("Invalid selection, try again later");
			
			}
			
		}while(choice !=0);
		sc.close();
		
	}

}
