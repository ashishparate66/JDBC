package com.Problem2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.Problem1.Product;

public class Main {

	
	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student (1,"ABC",550));
		list.add(new Student (2,"BCD",650));
		list.add(new Student (3,"PQRS",750));
		list.add(new Student (4,"ZMC",150));
		list.add(new Student (5,"NMC",250));
		
		Comparator<Student> comp = (p1,p2)->{
			if(p1.getMarks()< p2.getMarks()) 
				return 1;
			return -1;
		};
		List<Student> max=list.stream().sorted(comp).collect(Collectors.toList());
		System.out.println(max.get(0).getMarks());
	}
}
