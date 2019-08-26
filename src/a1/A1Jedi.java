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
		
		
		// Next, analyze the results and then print.
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
				Item thisItem; // This represents the main item that we are looking for.
				thisItem = getItemByName(item.getName(), itemsOfThisPerson);
				
				if (thisItem != null) {
					// This runs if the person actually bought the item.
					numCustomers++;
					
					// Now, add how many times the item was bought to the total:
					totalPurchases += thisItem.getNumberBought();
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
	
	private static Item getItemByName(String name, Item[] items) {
		for (Item i : items) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
}
