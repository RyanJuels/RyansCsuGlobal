
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Order orderQueue = new Order();
		Display display = new Display();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		int input;
		
		System.out.println("Welcome!\n");
		
		do {
			input = -1;
			printMenu();
			try {
				input = Integer.parseInt(scanner.next());
			} catch (Exception e) {

			}
			
			switch (input) {
			case 1: 
				System.out.println("\nAdding new Order to queue!\n");
				
				String name;
				int number = -1;
				double cost = -1;
				
				System.out.print("Please enter a last name for the order: ");
				name = scanner.next();
				
				do {
					System.out.print("Please enter an order-number for the order: ");
					try {
						number = Integer.parseInt(scanner.next());
					} catch (Exception e) {
						System.out.println("Please enter an integer!");
					}
				} while (number == -1);
				
				do {
					System.out.print("Please enter a price for the order: ");
					try {
						cost = Double.parseDouble(scanner.next());
					} catch (Exception e) {
						System.out.println("Please enter a number!");
					}
				} while (cost == -1);
				
				OrderInfo newData = new OrderInfo(name, number, cost);
				
				orderQueue.addOrder(newData);
				display.addToOrdersByName(newData);
				display.addToOrdersByNumber(newData);
				
				System.out.println(display.toString());
				
				break;
			case 2:
				System.out.println("\nRemoving next Order from queue!");
				OrderInfo temp = orderQueue.takeNextOrder();
				
				if (temp != null) {
					display.removeFromOrdersByName(temp);
					display.removeFromOrdersByNumber(temp);
				} else {
					System.out.println("Error: Queue is empty!\n");
				}
				break;
			case 3:
				System.out.println("\nPrinting data...");
				System.out.println("Order Queue: " + orderQueue.toString() );
				System.out.println(display.toString());
				break;
			case 4:
				System.out.println("\nExiting program...");
				exit = true;
				break;
			default:
				System.out.println("Please enter a number between 1 and 4!\n");
				break;
			}
			
		} while (exit == false);
		System.out.println("Goodbye!");
		scanner.close();
	}
	
	public static void printMenu() {
		System.out.println("Select an option to continue!");
		System.out.println("1) Add Order to Queue");
		System.out.println("2) Remove Order from Queue");
		System.out.println("3) Print Queue");
		System.out.println("4) Exit Program\n");
		System.out.print("Input: ");
	}
}