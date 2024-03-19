
public class SortedDetectorDriver {
	public static void main(String[] args) {
		SortedDetector sd = new SortedDetector();
		int[] myArrOne = new int[] {1, 2, 3, 5, 10, 14, 25};
		int[] myArrTwo = new int[] {1, 2, 3, 5, 10, 9, 25};
		
		System.out.println(sd.isSortedAscending(myArrOne));
		System.out.println(sd.isSortedAscending(myArrTwo));
	}
}
