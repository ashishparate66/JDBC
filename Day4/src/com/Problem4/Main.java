package com.Problem4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		
		Set<Student> set = new HashSet<>();

		set.add(new Student (1,"ABC",550));
		set.add(new Student (1,"ABC",550));
		set.add(new Student (2,"BCD",350));
		set.add(new Student (3,"PQRS",150));
		set.add(new Student (4,"ZMC",150));
		set.add(new Student (4,"ZMC",150));

		
		List<Student> newList=set.stream().filter(i-> i.getMarks()<500).collect(Collectors.toList());
		System.out.println(newList);
		
	}
}