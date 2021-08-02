package PrefixSum._0560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixsum = 0, cnt = 0;
        for (int num : nums) {
            prefixsum += num;
            if (map.containsKey(prefixsum - k))
                cnt += map.get(prefixsum - k);
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        return cnt;
    }
}
