import java.util.Stack;

public class PostfixConverter {
	public int priority(char input) {
		if(input == '^') {
			return 3;
		}
		else if(input == '/' || input == '*') {
			return 2;
		}
		else if(input == '+' || input == '-') {
			return 1;
		}
		
		//Default / error
		return -1;
	}

	public String postfix(String infix) {
		String retval = "";
		Stack<Character> stack = new Stack<>(); 
		for(int index = 0; index < infix.length(); index++) {
			char nextChar = infix.charAt(index);
			switch(nextChar) {
				case '^': 	
				case '-':
				case '+':
				case '*':
				case '/':
					while (!stack.isEmpty() && stack.peek() != '(' && (priority(nextChar) <= priority(stack.peek()))) {
						retval += stack.pop();
					}
					stack.push(nextChar);
					break;
					
				case '(':
					stack.push(nextChar);
					break;
					
				case ')':
					while (!stack.isEmpty() && stack.peek() != '(') {
						retval += stack.pop();
					}
					if (!stack.isEmpty()) {
						stack.pop();
					}
					break;
				default:
					retval += nextChar;
			}
		}
		
		while (!stack.isEmpty()) {
			retval += stack.pop();
		}
		
		return retval;
	}
}
