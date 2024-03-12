
public class FactorialDriver {

	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println("First Recussive function");
		System.out.println("--------------------------------");
		System.out.println("5! = " + f.firstFactorial(5));
		System.out.println("0! = " + f.firstFactorial(0));
		System.out.println("10! = " + f.firstFactorial(10));
		System.out.println("8! = " + f.firstFactorial(8));
		System.out.println("2! = " + f.firstFactorial(2));
		System.out.println("\nSecond Recussive function");
		System.out.println("--------------------------------");
		System.out.println("5! = " + f.secondFactorial(5));
		System.out.println("0! = " + f.secondFactorial(0));
		System.out.println("10! = " + f.secondFactorial(10));
		System.out.println("11! = " + f.secondFactorial(11));
		System.out.println("7! = " + f.secondFactorial(7));
	}
}
