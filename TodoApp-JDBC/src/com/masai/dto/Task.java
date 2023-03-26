package com.masai.dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class Task {
	private Integer taskId;
	private String taskName;
	private Date startDate;
	private Date endDate;
	public Task() {
		// TODO Auto-generated constructor stub
	}
	public Task(Integer taskId, String taskName, Date date, Date date2) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.startDate = date;
		this.endDate = date2;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}
	
	

}
