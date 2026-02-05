/*
You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. 
The window slides one position to the right until it reaches the right edge of the array.
Return a list that contains the maximum element in the window at each step.

Input: nums = [1,2,1,0,4,2,6], k = 3

Output: [2,2,4,4,6]

Explanation: 
Window position            Max
---------------           -----
[1  2  1] 0  4  2  6        2
 1 [2  1  0] 4  2  6        2
 1  2 [1  0  4] 2  6        4
 1  2  1 [0  4  2] 6        4
 1  2  1  0 [4  2  6]       6
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = k - 1,temp = Integer.MIN_VALUE;
        while(r < n){
            for(int i = l; i <= r; i++){
                temp = Math.max(nums[i],temp);
            }
            list.add(temp);
            r++;
            l++;
            temp = Integer.MIN_VALUE;
        }
        int[] result = new int[list.size()];
        // this fills the result arrayList. Now we convert it into array
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    /*
    This is brute force solution. Initially what i am doing here is sliding window 
    forward and iterating into that window to find the max.
    */
}
