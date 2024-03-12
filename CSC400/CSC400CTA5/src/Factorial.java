
public class Factorial {

	public int firstFactorial(int n) {
		if (1 == n || 0 == n) {
			return 1;
		}
		else {
			return n * firstFactorial(n - 1);
		}
	}
	
	public int secondFactorial(int n) {
		int sum = 1;
		if (1 == n || 0 == n) {
			return sum;
		}
		else {
			return (sum * n) * secondFactorial(n - 1); 
		}
	}
}
