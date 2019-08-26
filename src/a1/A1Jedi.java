/* 
 * Author: Leif Rasmussen
 * Date: August 25, 2019
 * Purpose: To parse input data from the console and print info about how
 * many people bought each item, and about the number of times that each 
 * item was purchased.
 */

package a1;

import java.util.Scanner;

public class A1Jedi {
	
	static Scanner scan;
	static Item[] storeItems; 
	static Person[] customers;

	public static void main(String[] args) {
		
		// First, get data:
		scan = new Scanner(System.in);
		parseData(); // This populates the storeItems and customers arrays from above.
		scan.close();
		
		
		// Next, analyze the results and print at the same time.
		for (Item item : storeItems) {
			// This loop runs for each item in the store.
			// Each iteration of this loop prints one line to the console.
			
			
			// Now, find out how many customers bought this item, 
			// and how many times the item was bought in total.
			int numCustomers = 0;
			int totalPurchases = 0;
			for (Person p : customers) {
				// This runs for each customer who visited the store.  
				Item[] itemsOfThisPerson = p.getItems();
				Item[] theseItems; // This represents the main item(s) that we are looking for.
				theseItems = getItemsByName(item.getName(), itemsOfThisPerson);
				
				if (theseItems != null) {
					// This runs if the person actually bought the item.
					numCustomers++;
					
					// Now, add how many times the item was bought to the total:
					for (Item i : theseItems) {
						totalPurchases += i.getNumberBought();
					}
				}
				
			}
			
			// Now, print the results for this item:
			if (numCustomers == 0) {
				System.out.println("No customers bought " + item.getName());
			} else {
				System.out.println(numCustomers + " customers bought " +
						totalPurchases + " " + item.getName());
			}
		}
		
	}
	
	/* 
	 * This method parses data from the console and updates the "items" 
	 * and "customers" arrays accordingly.  All info parsed is in some 
	 * way saved in those two arrays for later use.
	 * 
	 * The input is expected to follow the format found in README.md, 
	 * and if it doesn't follow that format, an exception will be thrown. 
	 */
	public static void parseData() {
		// First input is an integer indicating number of items in the store.
		int numStoreItems = scan.nextInt();
		storeItems = new Item[numStoreItems];
		
		// Now, read in all of the items, and then store them in an array.
		for (int i = 0; i < numStoreItems; i++) {
			// This loop runs for each item
			String name = scan.next();
			double price = scan.nextDouble();
			storeItems[i] = new Item(name, price);
		}
		
		
		// Now, deal with the customers.
		int numCustomers = scan.nextInt();
		customers = new Person[numCustomers];
		
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
	}
	
	/*
	 * This method searches through the input "items" array, and
	 * returns the first item with a name equal to the value of "name"
	 */
	private static Item getItemByName(String name, Item[] items) {
		for (Item i : items) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
	
	/*
	 * This method searches through the input "items" array, and returns every 
	 * item with a name equal to the value of "name".
	 */
	private static Item[] getItemsByName(String name, Item[] items) {
		// Get number of items that have name "name"
		int outputNum = 0;
		for (Item i : items) {
			if (i.getName().equals(name)) {
				outputNum++;
			}
		}
		if (outputNum == 0) {
			return null;
		}
		
		// Select these items and add the to the return object
		Item[] output = new Item[outputNum];
		int numberAdded = 0;
		for (Item i : items) {
			if (i.getName().equals(name)) {
				output[numberAdded] = i;
				numberAdded++;
			}
		}
		return output;
	}
}
