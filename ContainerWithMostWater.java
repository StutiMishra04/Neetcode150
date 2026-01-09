/*
You are given an integer array heights where heights[i] represents the height of the ith bar.
You may choose any two bars to form a container. Return the maximum amount of water a container can store.
Input: height = [1,7,2,5,4,7,3,6]
Output: 36
*/

class Solution {
    public int maxArea(int[] height) {
    int l = 0, r = height.length - 1, max = 0;
    int width = 0;
    while (l < r) {
        width = r - l;
        max = Math.max(max, Math.min(height[l], height[r]) * width);
        if (height[l] < height[r]) l++;
        else r--;
    }
    return max;
    }
}
