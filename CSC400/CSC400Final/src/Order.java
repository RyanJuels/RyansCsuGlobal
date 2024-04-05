
import java.util.LinkedList;
import java.util.Queue;

public class Order {

	Queue<OrderInfo> queue;
	
	public Order() {
		this.queue = new LinkedList<OrderInfo>();
	}
	
	public boolean addOrder(OrderInfo order) {
		return this.queue.offer(order);
	}
	
	public OrderInfo takeNextOrder() {
		return this.queue.poll();
	}
	
	@Override
	public String toString() {
		return queue.toString();	
	}

}