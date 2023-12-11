import java.util.Scanner;

public class Recursion {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double [] myArr = new double[5];
		for(int i = 0; i < 5; i++) {
			System.out.print("Next Number: ");
			myArr[i] = scan.nextDouble();
		}
		System.out.printf("The product is: %.2f", productOfNums(myArr));
	}
	
	public static double productOfNums(double[] arr) {
		if (arr.length == 1) {
			return arr[0];
		}
		else {
			double[] newArr = new double[arr.length - 1];
			for(int i = 1; i < arr.length; i++) {
				newArr[i - 1] = arr[i];
			}
			return arr[0] * productOfNums(newArr);
		}
	}
}
