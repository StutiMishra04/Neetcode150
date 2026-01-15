/*
Given a string s, find the length of the longest substring without duplicate characters.
A substring is a contiguous sequence of characters within a string.

Input: s = "zxyzxyz"
Output: 3
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            while( charSet.contains(s.charAt(r)) ){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
    /*
    Process following is:
    1. First create charSet with two pointers l (at left) and r (at right)
    2. If r is not in set, add r. If r is in set, then remove l and move it forward until
        the duplicate is out.
    3. use max function to get the max window size.

    consider string = "abcabcbb"
    a b c a b c b b
    |
    l,r 
    a b c a b c b b
    | |
    l r
    a b c a b c b b
    | | |
    l   r
    a b c a b c b b => (as a is duplicate, remove l until => a b c a b c b b
    | | | |             duplicate a is removed)                | | |
    l     r                                                    l   r
    a b c a b c b b => (as b is duplicate, remove l until => a b c a b c b b
      | | | |           duplicate b is removed)                  | | | 
      l     r                                                    l   r
    a b c a b c b b => (as c is duplicate, remove l until => a b c a b c b b
        | | | |         duplicate c is removed)                    | | |
        l     r                                                    l   r
    a b c a b c b b => (as b is duplicate, remove l until => a b c a b c b b
          | | | |       duplicate b is removed)                        | |
          l     r                                                      l r
    a b c a b c b b => (as b is duplicate, remove l  =>      a b c a b c b b
              | | |     until duplicate is removed)                        |
              l   r                                                        l,r
    */
}
