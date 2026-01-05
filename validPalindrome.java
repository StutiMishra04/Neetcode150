/*

Given a string s, return true if it is a palindrome otherwise return false.

Example: "Was it a car or a cat I saw?"

Output: true

*/

public class Solution{
  public static void validPalindrome(String input){
     StringBuilder newString = new StringBuilder();
     for(char c:input.toCharArray()){
	if(Character.isLetterOrDigit(c)){
	   newString.append(c);
	}
     }
     return newString.toString.equals(newString.reverse().toString());
  }
}
