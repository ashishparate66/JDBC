package com.Problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1,"Salt", 50, 10));
		list.add(new Product(2,"Cumin", 150, 5));
		list.add(new Product(3,"Soap", 130, 17));
		list.add(new Product(4,"Shampoo", 70, 12));
		list.add(new Product(5,"apple", 230, 2));
		

		System.out.println(list);
	    List<Product> list1 =	list.stream().filter(i-> i.getQuantity()>10).collect(Collectors.toList());
	    list1.forEach(i->System.out.println(i));
	   	
  	
		
	    System.out.println("=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=--=--=");
	   
		Comparator<Product> comp = (p1,p2)->{
			if(p1.getPrice()> p2.getPrice()) 
				return 1;
			return -1;
		};
		System.out.println(list);
		List<Product> list2 =  list.stream().sorted(comp).collect(Collectors.toList());
		list2.forEach(i->System.out.println(i));
			
		
	}


}
