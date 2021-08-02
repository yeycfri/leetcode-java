package PrefixSum._0523_Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum % k)) {
                if (i - map.get(sum % k) >= 2)
                    return true;
                continue;
            }
            map.put(sum % k, i);
        }
        return false;
    }
}
