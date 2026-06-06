class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                if (token.equals("+")) {
                    int result = num2 + num1;
                    numStack.push(result);
                } else if (token.equals("-")) {
                    int result = num2 - num1;
                    numStack.push(result);
                } else if (token.equals("*")) {
                    int result = num2 * num1;
                    numStack.push(result);
                } else if (token.equals("/")) {
                    int result = num2 / num1;
                    numStack.push(result);
                }
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.peek();
    }
}
