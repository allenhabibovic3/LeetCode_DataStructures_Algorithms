//USING A STACK TO CHECK IF STRING EXP OF PARENTHESIS ARE BALANCED
//balanced => {{}()}
//unbalanced => [[](]])
import java.util.ArrayDeque;
import java.util.Deque;

public class NQueens {
	public static boolean isBalanced(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(int i = 0; i < s.length(); i++) {
			char char_val = s.charAt(i);
			
			if(char_val == '(' || char_val == '[' || char_val == '{') {
				stack.push(char_val);
				continue;
			}
			
			if(stack.isEmpty())
				return false;
			
			switch(char_val) {
			stack.pop();
			case ')':
				if(char_val == '[' || char_val == '{')
					return false;
				break;
			case ']':
				if(char_val == '(' || char_val == '{')
					return false;
				break;
			case '}':
				if(char_val == '[' || char_val == '(')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String my_exp = "(()){}";
		
		boolean result = isBalanced(my_exp);
		
		System.out.println("The expression, " + my_exp + " is balanced: " + result);
	}
}
