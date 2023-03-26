package com.masai.dto;

import java.time.LocalDateTime;

public class TaskDTO {
	
	private String taskName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	
	public TaskDTO() {
		// TODO Auto-generated constructor stub
	}

	public TaskDTO(String taskName, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	
}
