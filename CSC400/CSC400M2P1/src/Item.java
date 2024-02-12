
public class Item {
	
	public Item(int customer_number, String item_name, double price) {
		super();
		this.customer_number = customer_number;
		this.item_name = item_name;
		this.price = price;
	}
	
	int customer_number;
	String item_name;
	double price;
	
	public int getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		String retval = "";
		retval += "Customer Number: " + customer_number + "\n";
		retval += "Item Name: " + item_name + "\n";
		retval += "Price: " + price;
		return retval;
	}
}
