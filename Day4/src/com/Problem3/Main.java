package com.Problem3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,8,6,12,9);
		
		Function<Integer,Integer> fn = i-> i*i;
//		list.stream().map(fn).collect(Collectors.toList());
		list.stream().map(fn).forEach(i-> System.out.print(i+" "));
//		
		System.out.println(list);
		
	}
}
