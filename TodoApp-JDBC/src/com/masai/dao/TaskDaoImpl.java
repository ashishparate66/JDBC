package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Task;
import com.masai.dto.TaskDTO;
import com.masai.exceptions.SomethingWentWrongException;

public class TaskDaoImpl implements TaskDao{

	@Override
	public void addTask(TaskDTO tdo) {
		
		Connection conn;
		try {
			conn = DBUtils.provideConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO task(taskName, startDate, endDate, userId) "
		    		+ "VALUES('"+ tdo.getTaskName() +"','"+ tdo.getStartDate() +"','"+ tdo.getEndDate() +"',"+ UserLoggedIn.UserLogged +")"); 
			int row = ps.executeUpdate();
			if(row>0) {
				System.out.println("Added Successfully.");
			}else {
				System.out.println("Couldn't add.");
			}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		
	}

	@Override
	public void updateTaskName(String newTaskName, String currentTaskName) throws SomethingWentWrongException {
		 
		Connection conn = null;
		try {
			conn = DBUtils.provideConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE task SET taskName = ? WHERE userId = ? AND taskName=?");
			ps.setString(1, newTaskName);
			ps.setInt(2, UserLoggedIn.UserLogged);
			ps.setString(3, currentTaskName);
			int row = ps.executeUpdate();
			
		} catch (ClassNotFoundException |SQLException e) {
			throw new SomethingWentWrongException(e.getMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new SomethingWentWrongException(e.getMessage());
			}
		}

	}

	@Override
	public void updateTaskStartAndEndTime(LocalDateTime startTime, LocalDateTime endTime, String currentTaskName)
			throws SomethingWentWrongException {

         Connection conn = null;
         try {
			 conn = DBUtils.provideConnection();
        	 PreparedStatement ps = conn.prepareStatement("UPDATE task SET startDate ='"+ startTime +"', endDate ='"+ endTime +"' WHERE userId = ? AND taskName=?");
        	 
        	 ps.setInt(1, UserLoggedIn.UserLogged);
        	 ps.setString(2, currentTaskName);
        	 ps.executeUpdate();
        	 
         }catch(SQLException | ClassNotFoundException ex) {
        	 throw new SomethingWentWrongException(ex.getMessage());	
         }
		
	}

	@Override
	public void makeTaskDone(String taskName) throws SomethingWentWrongException {
		Connection conn = null;
		try {
			conn = DBUtils.provideConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE task SET is_Done=1 WHERE taskName=? AND userId = ?");
			
			ps.setString(1, taskName);
			ps.setInt(2, UserLoggedIn.UserLogged);
			ps.executeUpdate();
			
		}catch(SQLException | ClassNotFoundException ex){
			throw new SomethingWentWrongException(ex.getMessage());
		}
		
	}

	@Override
	public List<Task> getAllTasks() throws SomethingWentWrongException {
		Connection conn = null;
		List<Task> list = new ArrayList<>();
		try {
			conn = DBUtils.provideConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM task where userId =?");
			ps.setInt(1, UserLoggedIn.UserLogged);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new SomethingWentWrongException("No Task Found.");
			}else {
				while(rs.next()) {
					list.add(new Task(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getDate(4)));
				}
			}
		}catch(SQLException | ClassNotFoundException ex) {
	           throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (ClassNotFoundException | SQLException e) {
				throw new SomethingWentWrongException(e.getMessage());
			} 
		}
		
		return list;
		
	}

	@Override
	public List<Task> getPendingAllTasks() throws SomethingWentWrongException {
		Connection conn = null;
		List<Task> list = new ArrayList<>();
		try {
			conn = DBUtils.provideConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM task WHERE userId =? AND is_Done=0");
			ps.setInt(1, UserLoggedIn.UserLogged);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new SomethingWentWrongException("No Task Found.");
			}else {
				while(rs.next()) {
					list.add(new Task(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getDate(4)));
				}
			}
		}catch(SQLException | ClassNotFoundException ex) {
	           throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (ClassNotFoundException | SQLException e) {
				throw new SomethingWentWrongException(e.getMessage());
			} 
		}
		
		return list;
		
	}

	@Override
	public List<Task> getTasksByDateRange(LocalDateTime startDate, LocalDateTime endDate)
			throws SomethingWentWrongException {
		Connection conn = null;
		List<Task> list = new ArrayList<>();
		try {
			conn = DBUtils.provideConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM task WHERE userId=? AND startDate BETWEEN '"+ startDate +"' AND '"+ endDate +"'");
			ps.setInt(1, UserLoggedIn.UserLogged);
			ResultSet rs = ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				throw new SomethingWentWrongException("No Task Found.");
			}else {
				while(rs.next()) {
					list.add(new Task(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getDate(4)));
				}
			}
		}catch(SQLException | ClassNotFoundException ex) {
	           throw new SomethingWentWrongException(ex.getMessage());
		}finally {
			try {
				DBUtils.closeConnection(conn);
			} catch (ClassNotFoundException | SQLException e) {
				throw new SomethingWentWrongException(e.getMessage());
			} 
		}
		
		return list;
		
	}

}
