package com.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<String> c1 = new ArrayList<>();
		
		Child c = new Child(c1);
		
		c.start();
		
		try {
			c.join();
		} catch (InterruptedException e) {	
			e.printStackTrace();
		}
		
		System.out.println("Main is Printing the cities");
		
		for(String city:c1) {
			System.out.println(city);
		}
	}
}

class Child extends Thread{
	List<String> cities;
	
	public Child(List<String> cities) {
		this.cities=cities;
	}
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			System.out.println("please enter a city name ");
			String city = sc.nextLine();
			cities.add(city);
		}
		
	}
}
