/*
Optimal Solution for Sliding window Maximum
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        Deque<Integer> deq = new ArrayDeque<>(); // stores indices
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {

            // 1️Remove indices that are out of the window
            if (!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            // 2️Maintain decreasing order in deque
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }

            // 3️Add current index
            deq.offerLast(i);

            // Window formed → record max
            if (i >= k - 1) {
                result[idx++] = nums[deq.peekFirst()];
            }
        }

        return result;
    }
}
