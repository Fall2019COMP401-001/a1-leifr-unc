package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DataParser parser = new DataParser();
		
		Person[] customers = parser.parseNovice(scan);
	
		scan.close();
		
		
		// Now, print everything.  
		
		print(customers);
	}
	
	private static void print(Person[] customers) {
		for (Person customer : customers) {
			System.out.println(customer);
		}
	}
}
