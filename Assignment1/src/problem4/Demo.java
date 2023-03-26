package problem4;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo {
	public static void main(String[] args) {
	Map<String, Student>  m = new HashMap<>();	
			m.put("Mumbai", new Student(1,"Ruhansh","ruhansh@gmail.com", 550));
			m.put("Delhi", new Student(2,"Mist","m@gmail.com", 650));
			m.put("Nagpur", new Student(3,"Harshal","h@gmail.com", 750));
			m.put("Banglore", new Student(4,"Shubham","s@gmail.com", 850));
			m.put("Goa", new Student(5,"Amit","a@gmail.com", 950));
			m.put("Pune", new Student(6,"Dipesh","d@gmail.com", 560));
			m.put("Nashik", new Student(7,"Yogesh","y@gmail.com", 630));		
			sort obj=(map)->{
				Map<String, Student> newmap=new LinkedHashMap<>();
				Set<Map.Entry<String,Student> > set=map.entrySet();
				List<Map.Entry<String,Student>> newlist=new ArrayList<>(set);
				Comparator<Map.Entry <String, Student>> student = (s1,s2)->{
					if(s1.getValue().getName().compareTo(s2.getValue().getName())< 0) {
						return 1;
					}else {
						return -1;
					}
				};
				Collections.sort(newlist,student);
				for(Map.Entry<String,Student> entry:newlist) {
					newmap.put(entry.getKey(),entry.getValue());
				}
				return newmap;
			};
			System.out.println(obj.sortMapUsingStudentName(m));
	}
}
interface sort{
	public Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap);
}

