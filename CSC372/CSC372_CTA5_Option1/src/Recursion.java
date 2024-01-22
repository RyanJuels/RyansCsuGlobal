import java.util.Arrays;
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
			double[] newArr = Arrays.copyOfRange(arr, 0, arr.length - 1);
			return arr[arr.length - 1] * productOfNums(newArr);
		}
	}
}
