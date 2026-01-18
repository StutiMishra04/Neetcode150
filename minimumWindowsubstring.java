/*
Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
You may assume that the correct output is always unique.

Input: s = "OUZODYXAZV", t = "XYZ"
Output: "YXAZ"
Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.

*/

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        
        HashMap<Character,Integer> TMap = new HashMap<>();
        HashMap<Character,Integer> WindowMap = new HashMap<>();
        
        // Fill TMap with characters from t
        for(int i = 0; i < t.length(); i++){
            TMap.put(t.charAt(i), TMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int required = TMap.size(); // Number of unique chars in t
        int formed = 0; // Number of unique chars in window with desired frequency
        
        while(r < s.length()){
            // Add character from right
            char c = s.charAt(r);
            WindowMap.put(c, WindowMap.getOrDefault(c, 0) + 1);
            
            // Check if this character's frequency matches what we need
            if(TMap.containsKey(c) && WindowMap.get(c).intValue() == TMap.get(c).intValue()){
                formed++;
            }
            
            // Try to shrink window from left while it's valid
            while(l <= r && formed == required){
                // Update minimum window
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    minStart = l;
                }
                
                // Remove character from left
                char leftChar = s.charAt(l);
                WindowMap.put(leftChar, WindowMap.get(leftChar) - 1);
                
                if(TMap.containsKey(leftChar) && WindowMap.get(leftChar) < TMap.get(leftChar)){
                    formed--;
                }
                
                l++;
            }
            
            r++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
    /*
    ADOBECODEBANC , ABC
    A|DOBECODEBANC, ABC
    We need two hashmaps, one for T and one for window
         ----------        -----------
        |  Window  |       |     T    |
        |char|count|       |char|count|
        |  A |  0  |       | A  |  1  |
        |  B |  0  |       | B  |  1  |
        |  C |  0  |       | C  |  1  |
        ------------       ------------
    Intitially, the window hasmap set over s will be empty.
    We want the count of characters in window hashamp to be >= characters in T
        A (in window HashMap) count >= A (in T HashMap)
    
    */
