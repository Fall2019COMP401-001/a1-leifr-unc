package a1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// First input is an integer indicating number of items in the store.
		int numStoreItems = scan.nextInt();
		Item[] storeItems = new Item[numStoreItems];
		
		// Now, read in all of the items, and then store them in an array.
		for (int i = 0; i < numStoreItems; i++) {
			// This loop runs for each item
			String name = scan.next();
			double price = scan.nextDouble();
			storeItems[i] = new Item(name, price);
		}
		
		
		// Now, deal with the customers.
		int numCustomers = scan.nextInt();
		Person[] customers = new Person[numCustomers];
		
		for (int i = 0; i < numCustomers; i++) {
			// This runs for each customer.
			String fName = scan.next();
			String lName = scan.next();
			int numBoughtItems = scan.nextInt();
			Item[] boughtItems = new Item[numBoughtItems];
			
			for (int j = 0; j < numBoughtItems; j++) {
				// This runs for each item the person bought.
				int numOfThisItem = scan.nextInt();
				String nameOfThisItem = scan.next();
				double price = getItemByName(nameOfThisItem, storeItems).getPrice();
				boughtItems[j] = new Item(numOfThisItem, nameOfThisItem, price);
			}
			
			customers[i] = new Person(fName, lName, boughtItems);
		}
		
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
	
	private static Item getItemByName(String name, Item[] items) {
		for (Item i : items) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
}
