package problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo2 {


	public static void main(String[] args) {
		List<Product> product = new ArrayList<>();
		product.add(new Product(1,"A",12,100));
		product.add(new Product(2,"B",12,1200));
		product.add(new Product(3,"C",12,620));
		product.add(new Product(4,"D",12,830));
		product.add(new Product(5,"E",12,390));
		

		
		
		Collections.sort(product, (p1, p2) -> p1.getPrice() < p2.getPrice()? 1: -1);
		System.out.println(product);
	}
	
}
