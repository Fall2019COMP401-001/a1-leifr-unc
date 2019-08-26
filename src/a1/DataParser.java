package a1;

import java.util.Scanner;

public class DataParser {
	public Person[] parseNovice (Scanner scan) {
		
		// First input is an integer indicating number of customers
		int numberOfCustomers = scan.nextInt();
		Person[] customers = new Person[numberOfCustomers];
		
		/* Next, for each customer, input will look like
		 * * First name of customer
		 * * Last name of customer
		 * * Number of items bought by customer
		 * * For each item bought, 
		 *   * An integer number of that item bought
		 *   * The name of the item (single word)
		 *   * The price of one of that item (a double).
		 *   
		 * To organize this information, and make the program adaptable for other uses
		 * in the future, two object types are used.  This avoids needlessly complicated
		 * arrays of arrays.  
		 */
		
		
		
		/* 
		 * Expected input for each customer:
		 * 
		 * <Customer First Name>
		 * <Last Name> 
		 * <number of items>
		 * <foreach item: 
		 *   <number bought>
		 *   <Name (one word)>
		 *   <price (double)>
		 * >
		 * 
		 */
		
		
		for (int i = 0; i < numberOfCustomers; i++) {
			// This loop runs one time per customer.
			String firstName = scan.next();
			String lastName = scan.next();
			
			int numberOfItems = scan.nextInt();
			Item[] items = new Item[numberOfItems];
			
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
	
	
	public Person[] parseAdeptJedi(Scanner scan) {
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
		return customers;
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
