package PrefixSum._0930_Binary_Subarrays_With_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixsum = 0, cnt = 0;
        for (int x : nums) {
            prefixsum += x;
            if (map.containsKey(prefixsum - goal))
                cnt += map.get(prefixsum - goal);
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        return cnt;
    }

    public int numSubarraysWithSumSlidingWindow(int[] nums, int goal) {
        int cnt = 0, n = nums.length;
        for (int l1 = 0, l2 = 0, s1 = 0, s2 = 0, r = 0; r < n; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > goal) s1 -= nums[l1++];
            while (l2 <= r && s2 >= goal) s2 -= nums[l2++];
            cnt += l2 - l1;
        }
        return cnt;
    }
}
