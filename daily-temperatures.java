/*
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. 
If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.

Input: temperatures = [30,38,30,36,35,40,28]
Output: [1,4,1,2,1,0,0]
*/
// BRUTE FORCE
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(temperatures[i] < temperatures[j]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
