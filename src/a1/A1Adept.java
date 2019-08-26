package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DataParser parser = new DataParser();
		
		Person[] customers = parser.parseAdeptJedi(scan);
		
		scan.close();
		
		// Now, print it all.
		DecimalFormat formatter = new DecimalFormat("#0.00");

		Person biggest = getBiggestSpender(customers);
		System.out.println("Biggest: " + biggest.getFirstName() + " " +
				biggest.getLastName() + " (" + formatter.format(biggest.getTotalSpent()) + ")");
		
		Person smallest = getSmallestSpender(customers);
		System.out.println("Smallest: " + smallest.getFirstName() + " " +
				smallest.getLastName() + " (" + formatter.format(smallest.getTotalSpent()) + ")");
		
		System.out.println("Average: " + formatter.format(getAverageSpent(customers)));
	}
	
	
	// Random methods
	
	private static Person getBiggestSpender(Person[] customers) {
		Person biggestSpender = customers[0];
		for (int i = 1; i < customers.length; i++) {
			if (customers[i].getTotalSpent() > biggestSpender.getTotalSpent()) {
				biggestSpender = customers[i];
			}
		}
		return biggestSpender;
	}
	
	private static Person getSmallestSpender(Person[] customers) {
		Person smallestSpender = customers[0];
		for (int i = 1; i < customers.length; i++) {
			if (customers[i].getTotalSpent() < smallestSpender.getTotalSpent()) {
				smallestSpender = customers[i];
			}
		}
		return smallestSpender;
	}
	
	private static double getAverageSpent(Person[] customers) {
		double total = 0;
		
		for (Person p : customers) {
			total += p.getTotalSpent();
		}
		
		return total / customers.length;
	}
}
