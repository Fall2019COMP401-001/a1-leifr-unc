package a1;

import java.text.DecimalFormat;

// Person objects.  These must store the first and last name, and the items bought.  
// They can contain items, making calculating how much these people spent easy.    

public class Person {
	
	String fName;
	String lName;
	Item[] items;
	

	// Constructor
	public Person(String firstName, String lastName, Item[] itemsBought) {
		items = itemsBought;
		fName = firstName;
		lName = lastName;
	}
	
	public String getFirstName() {
		return fName;
	}
	public char getFirstNameInitial() {
		return fName.charAt(0);
	}
	
	public String getLastName() {
		return lName;
	}
	
	public String getFormattedName() {
		// This method returns the first initial of the first name
		// followed by a dot, space, and then the last name.
		// Example: fName = "George", lName = "Pearson", output = "G. Pearson"
		
		return getFirstNameInitial() + ". " + getLastName();
	}
	
	public double getTotalSpent() {
		double total = 0;
		for (Item item : items) {
			total += item.getPrice() * item.getNumberBought();
		}
		return total;
	}
	
	public String toString() {
		// Prints the name followed by total spent by this person.
		DecimalFormat formatter = new DecimalFormat("#0.00");
		return getFormattedName() + ": " + formatter.format(getTotalSpent());
	}
	
	public Item[] getItems() {
		return items;
	}
}