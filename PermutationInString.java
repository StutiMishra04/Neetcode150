/*
You are given two strings s1 and s2.
Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
Both strings only contain lowercase letters.

Input: s1 = "abc", s2 = "lecabee"
Output: true
*/

public class Solution {
    public boolean checkInclusion(String s1, String s2){
        if (s1.length() > s2.length()) return false;
        // int windowSize = s1.length();
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        // now s1 is sorted.

        int l = 0, r = s1.length();
        while(r <= s2.length()){
            String temp = s2.substring(l,r);
            char[] tempArr = temp.toCharArray();
            Arrays.sort(tempArr);
            if(Arrays.equals(s1Arr,tempArr)){
                return true;
            }
            l++;
            r++;
        }
        return false;
    }
}
