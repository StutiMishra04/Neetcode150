/*
You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
Input: s = "XYYX", k = 2
Output: 4
*/

public class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        HashMap<Character,Integer> count = new HashMap<>();
        int l = 0, mostFreq = 0, winSize = 0, r = 0;
        while( r < s.length()){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            mostFreq = Math.max(mostFreq, count.get(s.charAt(r)));
            winSize = r - l + 1;
            if(winSize - mostFreq <= k){
                res = Math.max(res,winSize);
            }
            else if(winSize - mostFreq > k){
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return res;
    }
    /* k = 1
    A|ABABB|A  5 - 3 = 2 < 1, res = 4
           ___ ___
            A | 2  
            B | 3  mostfreq = 3
    */
}
