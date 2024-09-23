import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int val = 0;
                // if (token.equals("*")) val = a * b;
                // else if (token.equals("+")) val = a + b;
                // else if (token.equals("/")) val = a / b;
                // else if (token.equals("-")) val = a - b;
                switch (token) {
                    case "*":
                        val = a * b;
                        break;
                    case "+":
                        val = a + b;
                        break;
                    case "/":
                        val = a / b;
                        break;
                    case "-":
                        val = a - b;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }

                stack.push(val);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-");
    }
}
