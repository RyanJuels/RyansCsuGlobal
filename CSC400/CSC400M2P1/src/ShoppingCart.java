
public class ShoppingCart implements BagInterface<Item> {

	Item[] myBag;
	int default_capacity;
	int numberOfEntries;
	
	public ShoppingCart(int default_capacity) {
		super();
		this.default_capacity = default_capacity;
		this.numberOfEntries = 0;
		myBag = new Item[default_capacity];
	}
	
	public boolean isFull() {
		return numberOfEntries >= default_capacity;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries <= 0;
	}
	
	@Override
	public boolean add(Item newItem) {
		if (!isFull()) {
			myBag[numberOfEntries] = newItem;
			numberOfEntries++;
			return true;
		}
		else {
			System.out.println("Cart is full");
		}
		return false;
	}
	
	@Override
	public boolean remove(Item anItem) {
		if (!isEmpty()) {
			for (int i = 0; i < myBag.length; i++) {
				if(anItem == myBag[i]) {
					for (int j = i; j < myBag.length - 1; j++) {
						myBag[j] = myBag[j + 1];
					}
					myBag[default_capacity - 1] = null;
					numberOfEntries--;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Item[] toArray() {
		return myBag;
	}
}
