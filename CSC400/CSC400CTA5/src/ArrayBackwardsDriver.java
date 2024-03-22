import java.util.Arrays;

public class ArrayBackwardsDriver {
	public static void main(String[] args) {
		String[] arrayOne = new String[] {"This", "Should", "Be", "Printed", "Backwards"};
		Integer[] arrayTwo = new Integer[] {7, 6, 5, 4, 3, 2, 1};
		ArrayBackwards a = new ArrayBackwards();
		
		String[] resultOne = a.arrayBack(arrayOne, 0, arrayOne.length - 1);
		System.out.println("Reversed String array");
		System.out.println("-----------------------------------------");
		System.out.println(Arrays.toString(resultOne));
		
		
		
		Integer[] resultTwo = a.arrayBack(arrayTwo, 0, arrayTwo.length - 1);
		System.out.println("\n\nReversed Integer array");
		System.out.println("-----------------------------------------");
		System.out.println(Arrays.toString(resultTwo));
	}
}
