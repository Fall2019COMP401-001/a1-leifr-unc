package a1;


//Item objects.  These store just three variables: a name, a price, and number bought.
class Item {
	private String name;
	private double price;
	private int number;
	
	public Item(int numberBought, String name_, double price_) {
		name = name_;
		price = price_;
		number = numberBought;
	}
	
	public Item(String name_, double price_) {
		name = name_;
		price = price_;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberBought() {
		return number;
	}
}