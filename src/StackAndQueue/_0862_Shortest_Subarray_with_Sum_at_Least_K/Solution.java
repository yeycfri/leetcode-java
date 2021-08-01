package StackAndQueue._0862_Shortest_Subarray_with_Sum_at_Least_K;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = n + 1;
        int[] P = new int[n + 1];
        for (int i = 0; i < n + 1; i++) P[i + 1] = P[i] + nums[i];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (!deque.isEmpty() && P[i] <= P[deque.peekLast()])
                deque.pollLast();
            while (!deque.isEmpty() && P[i] >= P[deque.peekFirst()] + k)
                ans = Math.min(ans, i - deque.pollFirst());
            deque.offerLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }
}
