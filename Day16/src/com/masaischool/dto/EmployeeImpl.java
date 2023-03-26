package com.masaischool.dto;

public class EmployeeImpl implements Employee {

private String ename;
private String address;
private String mobile;
private int deptid;

public EmployeeImpl(String ename, String address, String mobile, int deptid) {
	super();
	
	this.ename = ename;
	this.address = address;
	this.mobile = mobile;
	this.deptid = deptid;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public int getDeptid() {
	return deptid;
}

public void setDeptid(int deptid) {
	this.deptid = deptid;
}

@Override
public String toString() {
	return "ename: " + ename + ", address: " + address + ", mobile: " + mobile + ", deptid: " + deptid + "\n";
}



}
