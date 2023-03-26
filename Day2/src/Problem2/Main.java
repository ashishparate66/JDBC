package Problem2;

public class Main {

	public Main() {}
	
	static void printByStatic(Student s) {
		System.out.println("Static");
		System.out.println(s);
	}
	
	void printByNonStatic(Student s) {
		System.out.println("Non-Static");
		System.out.println(s);
	}
	public Main(Student s) {
		System.out.println("Constructur");
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		Student std = new Student(18, "Virat", 47);
		
		Demo d1 = Main :: printByStatic;
		d1.printDetail(std);
		
		Demo d2 = new Main()::printByNonStatic;
		d2.printDetail(std);
		
		Demo d3 = Main :: new;
		d3.printDetail(std);
		
	}
	
	
}
