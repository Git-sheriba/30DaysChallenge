import java.util.ArrayDeque;
import java.util.Deque;
/*
 * Program to check if the given string of brackets are valid or not
 */
public class Day11_Challenge {

	public static boolean isInputValid(String s) {
		 
        if (null == s || s.trim().equals("")) {
            return true;
        }
 
        if (s.length() % 2 != 0) {
            return false;
        }
 
        int length = s.length();
 
        Deque<Character> stack = new ArrayDeque<Character>(length);
 
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (s.charAt(i)) {
 
                    case ')':
                        if (stack.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop() != '[') {
                            return false;
                        }
                        break;
 
                    case '}':
                        if (stack.pop() != '{') {
                            return false;
                        }
                        break;
                }
            }
        }
 
        return stack.isEmpty();
    }
    public static void main(String[] args) {
    	String str = "[{]}";
    	if(isInputValid(str))
    		System.out.println("The input is a valid input");
    	else
    		System.out.println("INVALID input");
	}

}
