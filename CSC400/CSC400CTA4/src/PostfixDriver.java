
public class PostfixDriver {
	public static void main(String[] args) {
		String firstString = "(a+b+c)*d*e/f";
		String secondString = "(a+b)/(c−d)";
		String thirdString = "a/(b−c)*d";
		String fourthString = "a−(b/(c−d)*e+f)^g";
		String fifthString = "a−b*c/d*e^f*g+h";
		String sixthString = "(a−b*c/d*e^f*g+h)";
		String seventhString = "((a−b)*c/d*)e^f*g+h";
		String eigthString = "a−b*c/d*e-f-g-h";
		PostfixConverter t = new PostfixConverter();
		
		System.out.println("Infix : " + firstString + "\nPostfix: " + t.postfix(firstString) + "\n");
		System.out.println("Infix : " + secondString + "\nPostfix: " + t.postfix(secondString) + "\n");
		System.out.println("Infix : " + thirdString + "\nPostfix: " + t.postfix(thirdString) + "\n");
		System.out.println("Infix : " + fourthString + "\nPostfix: " + t.postfix(fourthString) + "\n");
		System.out.println("Infix : " + fifthString + "\nPostfix: " + t.postfix(fifthString) + "\n");
		System.out.println("Infix : " + sixthString + "\nPostfix: " + t.postfix(sixthString) + "\n");
		System.out.println("Infix : " + seventhString + "\nPostfix: " + t.postfix(seventhString) + "\n");
		System.out.println("Infix : " + eigthString + "\nPostfix: " + t.postfix(eigthString) + "\n");
		
	}
}
