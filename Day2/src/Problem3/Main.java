package Problem3;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface PrintList {
abstract void display(List<String> city);
}

public class Main {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Mumbai");
		list.add("Nagpur");
		list.add("Delhi");
		list.add("Goa");

		PrintList la = (p) ->{
			System.out.println(p);
		};
		la.display(list);
	}

}
