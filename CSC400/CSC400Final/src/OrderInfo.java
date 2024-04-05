public class OrderInfo {

	private final String lastName;
	private final int orderNumber;
	private final double orderCost;

	public OrderInfo(String lastName, int orderNumber, double orderCost) {
		this.lastName = lastName;
		this.orderNumber = orderNumber;
		this.orderCost = orderCost;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public double getOrderCost() {
		return orderCost;
	}
	
	public int compareNames(OrderInfo o1) {
		return this.lastName.compareTo(o1.lastName);
	}
	
	public int compareNumbers(OrderInfo o1) {
		return this.orderNumber - o1.orderNumber;
	}

	@Override
	public String toString() {
		return "Order [lastName=" + lastName + ", orderNumber=" + orderNumber + ", orderCost=" + orderCost + "]";
	}
}