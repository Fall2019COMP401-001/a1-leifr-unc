/* 
 * Author: Leif Rasmussen
 * Date: August 25, 2019
 * Purpose: To parse input data from the console and print some basic
 * information about the parsed data.  
 */

package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		// First, get the data from the console.
		Scanner scan = new Scanner(System.in);
		
		Person[] customers = parseData(scan);
	
		scan.close();
		
		
		// Now, print everything.  
		print(customers);
	}
	
	/*
	 * This method parses the input and returns all parsed information 
	 * in a single Person[] object.
	 */
	private static Person[] parseData(Scanner scan) {
		
		// First input is an integer indicating number of customers
		int numberOfCustomers = scan.nextInt();
		Person[] customers = new Person[numberOfCustomers];
		
		// Next, deal with each customer.
		for (int i = 0; i < numberOfCustomers; i++) {
			// This loop runs one time per customer.
			String firstName = scan.next();
			String lastName = scan.next();
			
			// This states how many items the customer bought.  
			int numberOfItems = scan.nextInt();
			Item[] items = new Item[numberOfItems];
			
			// Deal with each item.
			for (int j = 0; j < numberOfItems; j++) {
				// This loop runs one time per item bought by the customer. 
				// It creates a new Item object for each item.
				int numberOfThisItem = scan.nextInt();
				String nameOfThisItem = scan.next();
				double priceOfThisItem = scan.nextDouble();
				items[j] = new Item(numberOfThisItem, nameOfThisItem, priceOfThisItem);
			}
		
			customers[i] = new Person(firstName, lastName, items);
		}
		return customers;
	}
	
	// Prints relevant information about each customer.
	private static void print(Person[] customers) {
		for (Person customer : customers) {
			System.out.println(customer);
		}
	}
}
