/*
Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.

Input: nums = [2,20,4,10,3,4,5]

Output: 4

Explanation: The longest consecutive sequence is [2, 3, 4, 5].
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int longest = 0;
        for(int num:numSet){
            if(!numSet.contains(num - 1)){ // if num is start of sequence
                int length = 1;
                while(numSet.contains(num + length)){
                    //if num = 1 and length = 1, this gets 2, then 3, then 4
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }

        return longest;
    }
}