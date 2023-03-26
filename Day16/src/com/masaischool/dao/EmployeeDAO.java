package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Employee;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface EmployeeDAO {

	public void addEmployee(Employee emp) throws SomethingWentWrongException;

	public List<Employee> getEmployeeDetails(String dname) throws SomethingWentWrongException, NoRecordFoundException;

}
