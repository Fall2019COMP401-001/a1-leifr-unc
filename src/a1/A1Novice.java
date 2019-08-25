package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
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
		
		scan.close();
		
		
		// Now, print everything.  
		
		for (Person customer : customers) {
			System.out.println(customer);
		}
	}
}
