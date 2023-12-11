package Stack;

public class BracketsValidator {

    public boolean isValidBrackets(String brackets) {
        boolean isValid = true;
        Stack<Character> stack = new Stack<Character>();
        char[] bracketsArray = brackets.toCharArray();
        for (int i = 0; i < bracketsArray.length; i++) {
            if (bracketsArray[i] == '(') {
                stack.push(bracketsArray[i]);
            }
            if (bracketsArray[i] == ')') {
                if (stack.size() == 0) {
                    isValid = false;
                }
                stack.pop();
            }
        }
        return stack.size() == 0 && isValid;
    }
}
