package problem1;

import java.util.List;
import java.util.function.Predicate;
import java.util.*;

public class Demo {

	public static void main(String[] args) {
		List<Employee> employee = new ArrayList<>();
	employee.add(new Employee(1, "Ruhansh", "Nagpur", 1200));
	employee.add(new Employee(2, "Harshal", "Chennai", 2000));
	employee.add(new Employee(3, "Harshal", "Ayodya", 5000));
	employee.add(new Employee(4, "Bhavesh", "Varanashi", 3500));
	employee.add(new Employee(5, "Ratnesh", "Goa", 4800));
	employee.add(new Employee(6, "Dipesh", "Kolkatta", 2200));
	employee.add(new Employee(7, "Pratik", "Banglore", 3000));
	employee.add(new Employee(8, "Shubham", "Nashik", 4200));
	employee.add(new Employee(9, "Vaishali", "Mumbai", 5800));
	employee.add(new Employee(10, "Kirti", "Delhi", 5700));
	

//	Collections.sort(employee, (e1,e2) -> e1.getSalary() > e2.getSalary()? 1: -1);
	Predicate<Employee> obj=emp-> emp.getSalary()<5000;
	
	for(Employee i:employee )
	{
		if(obj.test(i)) {
			int salary=i.getSalary()+1000;
			i.setSalary(salary);
		}
	}
//	for(Employee i:employee )
//	{
//		System.out.println(i);
//	}
	employee.forEach(s->System.out.println(s));
	}

	
}
