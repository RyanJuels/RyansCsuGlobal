
public class BagDemo {
	
	public static void testAdd(Item anItem, ShoppingCart cart) {
		System.out.println("Attempting to add item");
		boolean worked = cart.add(anItem);
		if (worked) {
		  System.out.println("Successfully added item");
		}
		else {
		  System.out.println("Failed to add item");
		}
	}
	
	public static void testRemove(Item anItem, ShoppingCart cart) {
		System.out.println("Attempting to remove item");
		boolean worked = cart.remove(anItem);
		if (worked) {
		  System.out.println("Successfully removed item");
		}
		else {
		  System.out.println("Failed to remove item");
		}
	}
	
	public static void displayBag(ShoppingCart cart) {
		Item[] toDisplay = cart.toArray();
		System.out.println("My Cart: ");
		for (int i = 0; i < toDisplay.length; i++) {
			if (toDisplay[i] != null) {
				System.out.println((i + 1) + ".");
				System.out.println(toDisplay[i].toString());
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		ShoppingCart myCart = new ShoppingCart(3);
		Item first = new Item(72943, "Apple", 4.27);
		Item second = new Item(72943, "Jelly", 5.65);
		Item third = new Item(72943, "Yogurt", 2.29);
		Item fourth = new Item(72943, "Chips", 4.50);
		
		testAdd(first, myCart);
		testAdd(second, myCart);
		
		System.out.println();
		displayBag(myCart);
		
		testAdd(third, myCart);
		testAdd(fourth, myCart);
		
		System.out.println();
		displayBag(myCart);
		
		testRemove(second, myCart);
		testAdd(fourth, myCart);
		
		System.out.println();
		displayBag(myCart);
		
		myCart.clear();
		System.out.println();
		displayBag(myCart);
		
	}
}
