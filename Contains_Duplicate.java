/*
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
--> Input: nums = [1, 2, 3, 3]
--> Output: true
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> answer = new HashSet<>();
        for(int i:nums){
            if(answer.contains(i)){
                return true;
            }
            answer.add(i);
        }
        return false;
    }
}
