package Problem1;

@FunctionalInterface
interface convertNum {

	public int convetStringToNumber(String s);
}

public class Main{
	
	public static void main(String[] args) {
		
		convertNum n = Integer::parseInt;
		
		System.out.println(n.convetStringToNumber("15")+1);
	}
}
