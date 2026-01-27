/*
You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
Return the integer that represents the evaluation of the expression.
The operands may be integers or the results of other operations.
The operators include '+', '-', '*', and '/'.
Assume that division between integers always truncates toward zero.

Input: tokens = ["1","2","+","3","*","4","-"]
Output: 5
Explanation: ((1 + 2) * 3) - 4 = 5
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        while (tokenList.size() > 1) {
            for (int i = 0; i < tokenList.size(); i++) {
                String token = tokenList.get(i);

                if ("+-*/".contains(token)) {
                    int a = Integer.parseInt(tokenList.get(i - 2));
                    int b = Integer.parseInt(tokenList.get(i - 1));
                    int result = 0;

                    if (token.equals("+")) {
                        result = a + b;
                    } else if (token.equals("-")) {
                        result = a - b;
                    } else if (token.equals("*")) {
                        result = a * b;
                    } else if (token.equals("/")) {
                        result = a / b;
                    }

                    tokenList.set(i - 2, String.valueOf(result));
                    tokenList.remove(i);
                    tokenList.remove(i - 1);
                    break;
                }
            }
        }
        return Integer.parseInt(tokenList.get(0));
    }
}
