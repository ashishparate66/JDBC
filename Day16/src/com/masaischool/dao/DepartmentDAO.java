package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Department;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomethingWentWrongException;

public interface DepartmentDAO {
	
	public void addDepartment(Department dept) throws SomethingWentWrongException;
	public List<Department> getDapartmentDetails() throws SomethingWentWrongException, NoRecordFoundException;
	public void deleteDepartment(String dname) throws SomethingWentWrongException;
}
