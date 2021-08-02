package PrefixSum._1248_Count_Number_of_Nice_Subarrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixsum = 0, cnt = 0;
        for (int x : nums) {
            prefixsum += x & 1;
            if (map.containsKey(prefixsum - k))
                cnt += map.get(prefixsum - k);
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        return cnt;
    }
}
