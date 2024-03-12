
public class ArrayBackwards {

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
