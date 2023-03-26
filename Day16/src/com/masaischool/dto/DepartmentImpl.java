package com.masaischool.dto;

public class DepartmentImpl implements Department {

	
	private String dname;
	private String location;
	
	public DepartmentImpl(String dname, String location) {
		super();
		
		this.dname = dname;
		this.location = location;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "dname: " + dname + ", location: " + location + "\n";
	}
	
	
}
