package StackAndQueue._0042_Trapping_Rain_Water;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = height[stack.pop()];
                if (stack.isEmpty()) break;

                int w = i - stack.peek() - 1;
                int h = Math.min(height[stack.peek()], height[i]) - bottom;
                ans += w * h;
            }
            stack.push(i);
        }
        return ans;
    }

    public int trapTwoPointers(int[] height) {
        int ans = 0, n = height.length;
        int l = 0, r = n - 1, lMax = 0, rMax = 0;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax) {
                ans += lMax - height[l++];
            } else {
                ans += rMax - height[r--];
            }
        }
        return ans;
    }

    public int trapDP(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] lMax = new int[n];
        lMax[0] = height[0];
        for (int i = 1; i < n; i++)
            lMax[i] = Math.max(lMax[i - 1], height[i]);

        int[] rMax = new int[n];
        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rMax[i] = Math.max(rMax[i + 1], height[i]);

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += Math.min(lMax[i], rMax[i]) - height[i];

        return ans;
    }
}
