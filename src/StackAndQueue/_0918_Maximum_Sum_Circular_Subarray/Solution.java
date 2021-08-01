package StackAndQueue._0918_Maximum_Sum_Circular_Subarray;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, ans = Integer.MIN_VALUE;
        int[] P = new int[2 * n];
        for (int i = 0; i < 2 * n - 1; i++)
            P[i + 1] = P[i] + nums[i % n];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        for (int i = 1; i < 2 * n; i++) {
            if (deque.peekFirst() < i - n)
                deque.pollFirst();
            ans = Math.max(ans, P[i] - P[deque.peekFirst()]);
            while (!deque.isEmpty() && P[i] < P[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        return ans;
    }

    public int maxSubarraySumCircularDP(int[] nums) {
        int n = nums.length, dp = nums[0], max = nums[0], sum = nums[0];
        // 不用到循环数组，相当于求最大子序列和
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }

        // 用到循环数组，求[1..n-2]的最小子序列和
        int min = 0;
        for (int i = 1; i < n - 1; i++) {
            dp = nums[i] + Math.min(dp, 0);
            min = Math.min(min, dp);
        }
        return Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{-2}));
        System.out.println(solution.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }
}
