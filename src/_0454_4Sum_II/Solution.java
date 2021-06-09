package _0454_4Sum_II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int tmp = i + j;
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int tmp = -i - j;
                if (map.containsKey(tmp)) count += map.get(tmp);
            }
        }
        return count;
    }
}
