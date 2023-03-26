package com.masai.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.TaskDao;
import com.masai.dao.TaskDaoImpl;
import com.masai.dto.Task;
import com.masai.dto.TaskDTO;
import com.masai.exceptions.SomethingWentWrongException;

public class TaskUI {
	
	static void addTask(Scanner sc) {
		System.out.print("Enter Task Name ");
		String taskName = sc.nextLine();
		System.out.print("Enter Start date ");
		LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.print("Enter end date ");
		LocalDateTime endDate = LocalDateTime.parse(sc.nextLine(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		
		TaskDTO tdto = new TaskDTO(taskName, startDate,endDate);
		
		TaskDao tdao = new TaskDaoImpl();
		tdao.addTask(tdto);
		
	}
	
	static void updateTaskName(Scanner sc) {
		System.out.println("Enter New Task Name ");
		String taskName = sc.nextLine();
		System.out.print("Enter Current Task Name");
		String currentTaskName = sc.nextLine();
		TaskDao tdao = new TaskDaoImpl();
		try {
			tdao.updateTaskName(taskName,currentTaskName);
			System.out.println("Updated Successfully.");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void changeStartAndEndTime(Scanner sc) {
		System.out.print("Enter New StartDate ");
		LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.println("Enter New End Date ");
		LocalDateTime endtDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.print("Enter Current Task Name ");
        String taskName = sc.nextLine();
        TaskDao tdao = new TaskDaoImpl();
        try {
			tdao.updateTaskStartAndEndTime(startDate, endtDate, taskName);
			System.out.println("Task Updated Successfully.");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void makeItDone(Scanner sc) {
		System.out.println("Enter Current Task Name ");
		String taskName = sc.nextLine();
		TaskDao tdao = new TaskDaoImpl();
		try {
			tdao.makeTaskDone(taskName);
			System.out.println("Updated Successfully..");
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	static void viewAllTasks() {
		TaskDao tdao = new TaskDaoImpl();
		try {
			List<Task> taskList = tdao.getAllTasks();
			
			for(Task t: taskList) {
				System.out.println(t);
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}
	static void viewPendingTask() {
		TaskDao tdao = new TaskDaoImpl();
		try {
			List<Task> taskList = tdao.getPendingAllTasks();
			
			for(Task t: taskList) {
				System.out.println(t);
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	static void viewTaskbetweenDateRange(Scanner sc) {
		System.out.print("Enter Starting Date  ");
		LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.print("Enter End Date  ");
		LocalDateTime endtDate = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		TaskDao tdao = new TaskDaoImpl();
		try {
			List<Task> taskList = tdao.getPendingAllTasks();
			
			for(Task t: taskList) {
				System.out.println(t);
			}
		} catch (SomethingWentWrongException e) {
			System.out.println(e.getMessage());
		}
		
	}


}
