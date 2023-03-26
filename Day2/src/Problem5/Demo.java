package Problem5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Demo {
	
	public static Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap){
		
		List<Map.Entry<String, Student>> list = new ArrayList<>(originalMap.entrySet());
		   
		
		
		Map<String,Student> finalmap = new LinkedHashMap<>();
		list.forEach(s ->{
			finalmap.put(s.getKey(), s.getValue());
		});
		return finalmap;
	}

	public static void main(String[] args) {
	
		Map<String, Student>  m = new HashMap<>();	
			m.put("India", new Student(1,"Ruhansh","ruhansh@gmail.com", 550));
			m.put("US", new Student(2,"Mist","m@gmail.com", 650));
			m.put("China", new Student(3,"Harshal","h@gmail.com", 350));
			m.put("Pak", new Student(4,"Shubham","s@gmail.com", 250));
			m.put("Nepal", new Student(5,"Amit","a@gmail.com", 150));
			m.put("UK", new Student(6,"Dipesh","d@gmail.com", 560));
			m.put("Aus", new Student(7,"Yogesh","y@gmail.com", 630));
					
			Map<String, Student> map1 = sortMapUsingStudentName(m);
			List<Map.Entry<String, Student>> list = new ArrayList<>(map1.entrySet());
			list.forEach((s)->{
				if(s.getValue().getMarks()>500) {
					
					System.out.println(s.getKey()+"  "+s.getValue());
				}
			});
			
			
	}
}


