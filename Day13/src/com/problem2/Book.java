package com.problem2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Book {

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
	
	static void addbook(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter  book Id");
		int  bookId = sc.nextInt();
		System.out.println("Please Enter  Book Name");
		String  bookName = sc.next();
		System.out.println("Please Enter book Price");
		double  bookPrice = sc.nextDouble();
		System.out.println("Please Enter book author");
		String bookAuthor = sc.next();
		System.out.println("Please Enter publish Year");
		String publishYear = sc.next();
		
		String query = "INSERT INTO BOOK VALUES ('"+bookId+"', '"+bookName+"', '"+bookPrice+"', '"+bookAuthor+"' ,'"+publishYear+"')";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("book added Successfully");
			System.out.println();
		}else {
			System.out.println("Not able to add books");
		}
		closeConnection(conn);
	}
	
	static void findBooksPrice() throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		Statement st = conn.createStatement();
		
		
		String query = "select * from book WHERE bookPrice BETWEEN '"+1000+"' AND '"+2000+"';";
		ResultSet rs = st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			System.out.println("No books Found");
		}else {
			while(rs.next()) {
				System.out.println("bookId: " + rs.getString(1) + " bookName: "+ rs.getString(2)+ " bookPrice: "+rs.getString(3)+ " bookAuthor: "+rs.getString(4)+ " publishYear: "+ rs.getString(5));
			}
		}
		closeConnection(conn);
	}
	
	static void findBooksAuthor(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter Author Name");
		String authorName = sc.next();
		
		String query = "select * from book WHERE bookAuthor = '"+ authorName +"';";
		ResultSet rs = st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			System.out.println("No Books available for this author");
		}else {
			while(rs.next()) {
				System.out.println("bookId: " + rs.getString(1) + " bookName: "+ rs.getString(2)+ " bookPrice: "+rs.getString(3)+ " bookAuthor: "+rs.getString(4)+ " publishYear: "+ rs.getString(5));
			}
		}
		closeConnection(conn);
	}
	
	static void displayAllBookYearWise(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter Year");
		String userpublishYear = sc.next();
		
		String query = "select * from book WHERE publishYear = '"+ userpublishYear +"';";
		ResultSet rs = st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			System.out.println("No Books available for this year");
		}else {
			while(rs.next()) {
				System.out.println("bookId: " + rs.getString(1) + " bookName: "+ rs.getString(2)+ " bookPrice: "+rs.getString(3)+ " bookAuthor: "+rs.getString(4)+ " publishYear: "+ rs.getString(5));
			}
		}
		closeConnection(conn);
	}
	
	static void viewAllBook() throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		Statement st = conn.createStatement();
		
		
		String query = "select * from book ";
		ResultSet rs = st.executeQuery(query);
		
		if(!rs.isBeforeFirst() && rs.getRow()==0) {
			System.out.println("No Books available");
		}else {
			while(rs.next()) {
				System.out.println("bookId: " + rs.getString(1) + " bookName: "+ rs.getString(2)+ " bookPrice: "+rs.getString(3)+ " bookAuthor: "+rs.getString(4)+ " publishYear: "+ rs.getString(5));
			}
		}
		closeConnection(conn);
	}
	
	static void deleteBook(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter BookID");
		int userBookId = sc.nextInt();
		
		String query = "DELETE FROM book where bookId = "+userBookId+"";
		int res =st.executeUpdate(query);
		
		if(res > 0) {
			System.out.println(res + " book delete Successfully");
			System.out.println();
		}else {
			System.out.println("Invalid Book Id");
		}
		closeConnection(conn);
	}
static void UpdateBook(Scanner sc) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnectionTodatabase();
		
		Statement st = conn.createStatement();
		
		System.out.println("Please Enter Your book Id");
		int  bookId = sc.nextInt();
		System.out.println("Please Enter Author Name");
		String  bookAuthor = sc.next();
		
		
		String query = "UPDATE book SET bookAuthor = '"+bookAuthor+"' Where bookId = "+bookId+"";
		
		if(st.executeUpdate(query) > 0) {
			System.out.println("book Author update Successfully");
			System.out.println();
		}else {
			System.out.println("Unable to update author");
		}
		closeConnection(conn);
	 }
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		
		int choice =0;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. find Book Author");
			System.out.println("3. find Book Price");
			System.out.println("4. View All Books ");
			System.out.println("5. Display All Book Year Wise");
			System.out.println("6. Delete Books");
			System.out.println("7. Updates Books");
			System.out.println("0. EXIT");
			
			System.out.println("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addbook(sc);
					break;
				case 2:
					findBooksAuthor(sc);
					break;
				case 3:
					findBooksPrice();
					break;
				case 4:
					viewAllBook();
					break;
				case 5:
					displayAllBookYearWise(sc);
					break;
				case 6:
					deleteBook(sc);
					break;
				case 7:
					UpdateBook(sc);
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