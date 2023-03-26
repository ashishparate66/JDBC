package problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		List<Employee1> employee = new ArrayList<>();
	employee.add(new Employee1(1, "Ruhansh", "Nagpur", 1200));
	employee.add(new Employee1(2, "Harshal", "Chennai", 2000));
	employee.add(new Employee1(3, "Harshal", "Ayodya", 5000));
	employee.add(new Employee1(4, "Bhavesh", "Varanashi", 3500));
	employee.add(new Employee1(5, "Ratnesh", "Goa", 4800));
	employee.add(new Employee1(6, "Dipesh", "Kolkatta", 2200));
	employee.add(new Employee1(7, "Pratik", "Banglore", 3000));
	employee.add(new Employee1(8, "Shubham", "Nashik", 4200));
	employee.add(new Employee1(9, "Vaishali", "Mumbai", 3800));
	employee.add(new Employee1(10, "Kirti", "Delhi", 1700));
	
	
	
		 
	Comparator<Employee1> cities = (e1,e2) ->{
		
		if(e1.getAddress().compareTo(e2.getAddress())<0) {
			return 1;
		}else {
			return -1;
		}
		
	};
	Collections.sort(employee, cities);
	
	System.out.println(employee);
	}
}
