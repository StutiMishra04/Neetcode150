/*
You are given an array of non-negative integers height which represent an elevation map. Each value height[i] represents the height of a bar, which has a width of 1.
Return the maximum area of water that can be trapped between the bars.
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int[] maxleft = new int[n];
        int[] maxright = new int[n];

        maxleft[0] = height[0];
        for(int i = 1; i < n; i++){
            maxleft[i] = Math.max( maxleft[i - 1], height[i] );
        }

        maxright[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxright[i] = Math.max( maxright[i + 1] , height[i] );
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            result += Math.min( maxleft[i] , maxright[i] ) - height[i];
        }
        return result;
    }
}
