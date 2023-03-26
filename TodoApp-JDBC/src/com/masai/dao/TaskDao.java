package com.masai.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.masai.dto.Task;
import com.masai.dto.TaskDTO;
import com.masai.exceptions.SomethingWentWrongException;

public interface TaskDao {
	
	public void addTask(TaskDTO tdo);
	public void updateTaskName(String newTaskName, String currentTaskName)throws SomethingWentWrongException;
	public void updateTaskStartAndEndTime(LocalDateTime startTime, LocalDateTime endTime, String currentTaskName)throws SomethingWentWrongException;
	public void makeTaskDone(String taskName)throws SomethingWentWrongException;
	public List<Task> getAllTasks()throws SomethingWentWrongException;
	public List<Task> getPendingAllTasks()throws SomethingWentWrongException;
	public List<Task> getTasksByDateRange(LocalDateTime startDate, LocalDateTime endDate)throws SomethingWentWrongException;
	
	

}
