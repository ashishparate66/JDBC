package com.p4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Country c = new Country();
		Master m = new Master(c);
		Student s = new Student(c);
		
		m.start();
		s.start();
		
		try {
			m.join();
			s.join();
		} catch (InterruptedException e) {
			
		}
		System.out.println("Bye Bye Main");
	}
	
	
}

class Master extends Thread{
	Country c;
	
	public Master(Country c) {
		
		this.c=c;
	}
	@Override
	public void run() {
		c.askCapitalName();
	}
}

class Student extends Thread{
	Country c;
	
	public Student(Country c) {
		
		this.c=c;
	}
	@Override
	public void run() {
		c.printCapitalName();
	}
}

class Country{
	static Map<String, String> map;
	String countryName = null;
	static {
		map = new LinkedHashMap<>();
		
		map.put("Afghanistan", "kabul");
		map.put("Belgium", "Brussels");
		map.put("Canada", "Ottawa");
		map.put("Egypt", "Cairo");
		map.put("Finland", "Helsinki");
		map.put("Greece", "Athens");
		map.put("Hungary", "Budapest");
		map.put("Iraq", "Baghdad");
		map.put("Norway", "Oslo");
		map.put("South Korea", "Seoul");
	}
	synchronized void askCapitalName() {
		List<String> list = new ArrayList<>(map.keySet());
	   
		while(!list.isEmpty()) {
		   int index = (int)(Math.random()*list.size());
			countryName = list.get(index);
			list.remove(countryName);
			System.out.println("What is your Capital Name "+countryName);
			
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		notify();
		
	}
	synchronized void printCapitalName() {
		if(countryName==null) 
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	
		
		while(!map .isEmpty()) {
			System.out.println("The capital of "+ countryName +" is "+map.get(countryName));
			  map.remove(countryName);
			  
			  notify();
			  try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			 
		}
		
		
	}
	
}
