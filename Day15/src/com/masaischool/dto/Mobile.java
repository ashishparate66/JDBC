package com.masaischool.dto;

import java.time.LocalDate;

public interface Mobile {

	public String getModel_no(); 
	public void setModel_no(String model_no); 
	public String getCompany(); 
	public void setCompany(String company); 
	public int getPrice(); 
	public void setPrice(int price); 
	public LocalDate getMfgdate();
	public void setMfgdate(LocalDate mfgdate);
	
}
