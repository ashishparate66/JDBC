package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.dto.UserDTO;
import com.masai.exceptions.SomethingWentWrongException;

public class UserDaoImpl implements UserDao {

	@Override
	public void signUp(UserDTO udto) {
	    
		try {
			Connection con = DBUtils.provideConnection();
			
			PreparedStatement ps =con.prepareStatement("INSERT INTO user(name, username, password) VALUES(?,?,?)");
			ps.setString(1, udto.getName());
			ps.setString(2, udto.getUsername());
			ps.setString(3, udto.getPassword());
			
			int row = ps.executeUpdate();
			
			if(row>0) {
				System.out.println("User has Signed Up Successfully.");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void login(String username, String password) throws SomethingWentWrongException {
		
		Connection con=null;
		try {
			con = DBUtils.provideConnection();
			PreparedStatement ps = con.prepareStatement("select userId from user where username =? AND password=?");
			ps.setString(1, username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)){
				throw new SomethingWentWrongException("Invalid Username and Password");
			}
			rs.next();
			UserLoggedIn.UserLogged=rs.getInt(1);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.closeConnection(con);
			} catch (ClassNotFoundException | SQLException  e) {
				e.printStackTrace();
			}
		}
	
		
	}

	@Override
	public void signOut() {
		UserLoggedIn.UserLogged=0;
		
	}

}
