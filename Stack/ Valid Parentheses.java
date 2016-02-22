/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']'
 * determine if the input string is valid.
 */
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //Push left side characters to the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                //Pop if match the pattern
                //Must test if stack is empty!!!
                //If stack is empty, is_valid method won't work!!!
                if (!stack.isEmpty() && is_valid(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    //A method to determine whether it matches the pattern
    public boolean is_valid(char c1, char c2) {
        return ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']'));
    }
}