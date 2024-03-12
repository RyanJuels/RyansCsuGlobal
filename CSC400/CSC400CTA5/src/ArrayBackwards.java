
public class ArrayBackwards {
	
	//This function will be O(1/2n) since we are doing half of the portion of the array
	//Because we get rid of constants, this will be O(n)
	public <T> T[] arrayBack(T[] arr, int start, int end) {
		if (start < end) {
			T temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;
			arrayBack(arr, start + 1, end - 1);
		}
		return arr;
	}
}
