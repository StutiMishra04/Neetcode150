/*
You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:
1 --> Every open bracket is closed by the same type of close bracket.
2 --> Open brackets are closed in the correct order.
3 --> Every close bracket has a corresponding open bracket of the same type.
4 --> Return true if s is a valid string, and false otherwise.

Input: s = "[]"
Output: true
*/

class Solution {
    public boolean isValid(String str) {
        Stack<Character> ans = new Stack<>();
        for(char ch: str.toCharArray()){
            if(ch == '(') ans.push(')');
            else if (ch =='{') ans.push('}');
            else if (ch == '[') ans.push(']');
            
            else if(ans.isEmpty() || ans.pop() != ch){
                return false;
            }
        }
        return ans.isEmpty();
    }
}
