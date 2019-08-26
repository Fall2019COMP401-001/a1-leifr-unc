/*
 * Author: Leif Rasmussen
 * Date: August 25, 2019
 * Purpose: To parse input data from the console and print info about the 
 * biggest, smallest spenders, and average spent.  
 */

package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Adept {
	
	// Main method
	public static void main(String[] args) {
		
		
		// Get data with a scanner and parse it into "customers"
		Scanner scan = new Scanner(System.in);
		
		Person[] customers = parseData(scan);
		
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
	
	
	/*
	 * Returns the Person who spent the most by searching through
	 * the input "customers" array.  Each person in that array stores
	 * information about what they bought, so that is where this info comes from.
	 */
	private static Person getBiggestSpender(Person[] customers) {
		Person biggestSpender = customers[0];
		// Loop through the rest of the customers and find the biggest spender.
		for (int i = 1; i < customers.length; i++) {
			if (customers[i].getTotalSpent() > biggestSpender.getTotalSpent()) {
				biggestSpender = customers[i];
			}
		}
		return biggestSpender;
	}
	
	/*
	 * Returns the Person who spent the least by searching through
	 * the input "customers" array.  Each person in that array stores
	 * information about what they bought, so that is where this info comes from.
	 */
	private static Person getSmallestSpender(Person[] customers) {
		Person smallestSpender = customers[0];
		// Loop through the rest of the customers and find the smallest spender.
		for (int i = 1; i < customers.length; i++) {
			if (customers[i].getTotalSpent() < smallestSpender.getTotalSpent()) {
				smallestSpender = customers[i];
			}
		}
		return smallestSpender;
	}
	
	/*
	 * Finds the mean average amount spent by the people in "customers"
	 */
	private static double getAverageSpent(Person[] customers) {
		double total = 0;
		
		for (Person p : customers) {
			total += p.getTotalSpent();
		}
		
		return total / customers.length;
	}
	
	/*
	 * Parses data from the console, expecting a certain format from README.md.  
	 * If the format is not exactly as expected, an exception will be thrown.  
	 * 
	 * Returns a Person array containing all of the information received via the 
	 * console.   
	 */
	private static Person[] parseData(Scanner scan) {
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
			// This loop runs for each customer.
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
		return customers;
	}
	
	/*
	 * Searches through the array "items" and returns the first one that has a name 
	 * equal to "name".
	 * If no names are found, null is returned.
	 */
	private static Item getItemByName(String name, Item[] items) {
		for (Item i : items) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
}
