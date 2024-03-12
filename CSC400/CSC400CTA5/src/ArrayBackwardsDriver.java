
public class ArrayBackwardsDriver {
	public static void main(String[] args) {
		String[] arrayOne = new String[] {"This", "Should", "Be", "Printed", "Backwards"};
		Integer[] arrayTwo = new Integer[] {7, 6, 5, 4, 3, 2, 1};
		ArrayBackwards a = new ArrayBackwards();
		String[] resultOne = a.arrayBack(arrayOne, 0, arrayOne.length - 1);
		
		
		for (String i : resultOne) {
			System.out.println(i);
		}
		
		
		Integer[] resultTwo = a.arrayBack(arrayTwo, 0, arrayTwo.length - 1);
		
		
		for (int i : resultTwo) {
			System.out.println(i);
		}
	}
}
