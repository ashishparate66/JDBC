package com.masaischool.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.dto.Mobile;
import com.masaischool.dto.MobileImpl;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public class MobileDAOImpl implements MobileDAO {

	public void addMobile(Mobile mb) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "INSERT INTO mobile (model_no, company, price, mfgdate) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, mb.getModel_no());
			ps.setString(2, mb.getCompany());
			ps.setInt(3, mb.getPrice());
			ps.setDate(4, Date.valueOf(mb.getMfgdate()));
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to insert the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}
	public void updateMobile(Mobile mb) throws SomethingWentWrongException{
		
			Connection conn = null;
			try {
				conn = DBUtils.getConnectionTodatabase();
				String query = "UPDATE mobile SET company = ?, price = ?, mfgdate = ? WHERE model_no = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, mb.getCompany());
				ps.setInt(2, mb.getPrice());
				ps.setDate(3, Date.valueOf(mb.getMfgdate()));
				ps.setString(4, mb.getModel_no());
				ps.executeUpdate();
			}catch(ClassNotFoundException | SQLException ex) {
				throw new SomethingWentWrongException("Unable to update the record now, try again later");
			}finally {
				try {
					DBUtils.closeConnection(conn);					
				}catch(SQLException ex) {
					
				}
			}	
	}
	public void deleteMobile(String model_no) throws SomethingWentWrongException{
		Connection conn = null;
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "DELETE FROM mobile WHERE model_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, model_no);
			ps.executeUpdate();
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to delete the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
	}
	
	public List<Mobile> getMobileList() throws SomethingWentWrongException, NoRecordFoundException{
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT model_no, company, price, mfgdate FROM mobile";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Mobile found");
			}
			while(rs.next()) {
				list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to update the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}
	
	public List<Mobile> searchMobileByModelNo(String model_no) throws SomethingWentWrongException, NoRecordFoundException{
		
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT model_no, company, price, mfgdate FROM mobile WHERE model_no = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, model_no);
			
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Mobile found");
			}
			while(rs.next()) {
				list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to Search the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return list;
		
	}	
	public List<Mobile> searchMobileByPriceRange(int price1, int price2) 
			throws SomethingWentWrongException, NoRecordFoundException{
		
		Connection conn = null;
		List<Mobile> list = new ArrayList<>();
		try {
			conn = DBUtils.getConnectionTodatabase();
			String query = "SELECT model_no, company, price, mfgdate FROM mobile WHERE price BETWEEN ? AND ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, price1);
			ps.setInt(2, price2);
			
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new NoRecordFoundException("No Mobile found");
			}
			while(rs.next()) {
				list.add(new MobileImpl(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
			}
			
		}catch(ClassNotFoundException | SQLException ex) {
			throw new SomethingWentWrongException("Unable to Search the record now, try again later");
		}finally {
			try {
				DBUtils.closeConnection(conn);					
			}catch(SQLException ex) {
				
			}
		}
		return list;
	}
}
