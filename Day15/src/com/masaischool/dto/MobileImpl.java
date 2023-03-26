package com.masaischool.dto;

import java.time.LocalDate;

public class MobileImpl implements Mobile{
	
	private String model_no;
	private String company;
	private int price;
	private LocalDate mfgdate;
	
	public MobileImpl(String model_no, String company, int price, LocalDate mfgdate) {
		
		this.model_no = model_no;
		this.company = company;
		this.price = price;
		this.mfgdate = mfgdate;
	}
	@Override
	public String getModel_no() {
		return model_no;
	}
	@Override
	public void setModel_no(String model_no) {
		this.model_no = model_no;
	}
	@Override
	public String getCompany() {
		return company;
	}
	@Override
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public int getPrice() {
		return price;
	}
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public LocalDate getMfgdate() {
		return mfgdate;
	}
	@Override
	public void setMfgdate(LocalDate mfgdate) {
		this.mfgdate = mfgdate;
	}	
}
