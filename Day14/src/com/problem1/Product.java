package com.problem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Product {

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
	
	static void addProduct(Scanner sc) {
		
		Connection conn =null;
		try {
			conn= getConnectionTodatabase();
			String query = "INSERT INTO product(pid, pname, quantity, price) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.println("Please Enter Your Product Id");
			int  pid = sc.nextInt();
			System.out.println("Please Enter Product Name");
			String  pname = sc.next();
//			sc.nextLine();
			System.out.println("Please Enter Product Quantity");
			int  quantity = sc.nextInt();
			System.out.println("Please Enter Product Price");
			int price = sc.nextInt();
			
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setInt(3, quantity);
			ps.setInt(4, price);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Product added Successfully");
				System.out.println();
			}else {
				System.out.println("Not able to add Product");
			}
	
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				} catch (SQLException ex) {
					
				}
			}
		}
	}
	
	static void addProductwithoutQtyAndPrice(Scanner sc) {
		
		Connection conn =null;
		try {
			conn= getConnectionTodatabase();
			String query = "INSERT INTO product(pid, pname) VALUES (?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.println("Please Enter Your Product Id");
			int  pid = sc.nextInt();
			System.out.println("Please Enter Product Name");
			String  pname = sc.next();
//			sc.nextLine();
		
			ps.setInt(1, pid);
			ps.setString(2, pname);
		
			if(ps.executeUpdate() > 0) {
				System.out.println("Product added Successfully");
				System.out.println();
			}else {
				System.out.println("Not able to add Product");
			}
	
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				} catch (SQLException ex) {
					
				}
			}
		}
	}
	static void UpdateQtyAndPrice(Scanner sc) {
		
		Connection conn =null;
		try {
			conn= getConnectionTodatabase();
			String query = "UPDATE product SET quantity = ?, price = ? WHERE pid = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.println("Please Enter Your Product Id");
			int  pid = sc.nextInt();
			
			System.out.println("Please Enter Product Quantity");
			int  quantity = sc.nextInt();
			System.out.println("Please Enter Product Price");
			int price = sc.nextInt();
	
			ps.setInt(1, quantity);
			ps.setInt(2, price);
			ps.setInt(3, pid);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Product update Successfully");
				System.out.println();
			}else {
				System.out.println("Not able to add Product");
			}
	
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				} catch (SQLException ex) {
					
				}
			}
		}
	}
	
static void deleteProductQtyLessTwo(Scanner sc) {
		
		Connection conn =null;
		try {
			conn= getConnectionTodatabase();
			String query = "DELETE FROM product WHERE quantity < 2";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
		
			if(ps.executeUpdate() > 0) {
				System.out.println("Product delete Successfully");
				System.out.println();
			}else {
				System.out.println("Not able to add Product");
			}
	
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				} catch (SQLException ex) {
					
				}
			}
		}
	}

	static void viewProduct() {
		
		Connection conn =null;
		try {
			conn= getConnectionTodatabase();
			String query = "select * from product";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
		
			if( !rs.isBeforeFirst() && rs.getRow()==0) {
				System.out.println("NO Product Found");
			}else {
				while(rs.next()) {
					System.out.println("Product Id: "+ rs.getString(1) + " Product Name: "+rs.getString(2)+ " Quantity: "+rs.getString(3)+ " Price: "+rs.getString(4));
				}
			}
	
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				} catch (SQLException ex) {
					
				}
			}
		}
	}
	static void searchProductByName(Scanner sc) {
			
			Connection conn =null;
			try {
				conn= getConnectionTodatabase();
				String query = "select * from product where pname = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				
				System.out.println("Please Enter Product Name");
				String  pname = sc.next();
				
				ps.setString(1, pname);
				
				ResultSet rs = ps.executeQuery();
			
				if( !rs.isBeforeFirst() && rs.getRow()==0) {
					System.out.println("NO Product Found");
				}else {
					while(rs.next()) {
						System.out.println("Product Id: "+ rs.getString(1) + " Product Name: "+rs.getString(2)+ " Quantity: "+rs.getString(3)+ " Price: "+rs.getString(4));
					}
				}
		
			} catch (ClassNotFoundException | SQLException ex) {
				System.out.println(ex);
			}finally {
				if(conn != null) {
					try {
						closeConnection(conn);
					} catch (SQLException ex) {
						
					}
				}
			}
		}
	
	static void searchProductByPrice(Scanner sc) {
		
		Connection conn =null;
		try {
			conn= getConnectionTodatabase();
			String query = "select * from product where price = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			System.out.println("Please Enter Product Price");
			int  price = sc.nextInt();
			
			ps.setInt(1, price);
			
			ResultSet rs = ps.executeQuery();
		
			if( !rs.isBeforeFirst() && rs.getRow()==0) {
				System.out.println("NO Product Found");
			}else {
				while(rs.next()) {
					System.out.println("Product Id: "+ rs.getString(1) + " Product Name: "+rs.getString(2)+ " Quantity: "+rs.getString(3)+ " Price: "+rs.getString(4));
				}
			}
	
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex);
		}finally {
			if(conn != null) {
				try {
					closeConnection(conn);
				} catch (SQLException ex) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice =0;
		do {
			System.out.println("1 . Add Product");
			System.out.println("2 . Add Product without quantity and price");
			System.out.println("3. Update quantity and price");
			System.out.println("4. Delete All product whose quantity less than 2");
			System.out.println("5. View List of Product");
			System.out.println("6. Search Product by name");
			System.out.println("7. Search Product by price Name");
			System.out.println("0. EXIT");
			
			System.out.println("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addProduct(sc);
					break;
				case 2:
					addProductwithoutQtyAndPrice(sc);
					break;
				case 3:
					UpdateQtyAndPrice(sc);
					break;
				case 4:
					deleteProductQtyLessTwo(sc);
					break;
				case 5:
					viewProduct();
					break;
				case 6:
					searchProductByName(sc);
					break;
				case 7:
					searchProductByPrice(sc);
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
