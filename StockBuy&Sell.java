/*
You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.
You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

Input: prices = [10,1,5,6,7,1]
Output: 6
*/

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i + 1; j < prices.length; j++){
                res = Math.max(prices[j] - prices[i],res);
            }
        }
        return res;
    }
}
