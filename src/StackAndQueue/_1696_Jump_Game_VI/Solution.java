package StackAndQueue._1696_Jump_Game_VI;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length, ans = nums[0];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{ans, 0});
        for (int i = 1; i < n; i++) {
            while (deque.peekFirst()[1] < i - k)
                deque.pollFirst();
            ans = nums[i] + deque.peekFirst()[0];
            while (!deque.isEmpty() && deque.peekLast()[0] < ans)
                deque.pollLast();
            deque.offerLast(new int[]{ans, i});
        }
        return ans;
    }
}
