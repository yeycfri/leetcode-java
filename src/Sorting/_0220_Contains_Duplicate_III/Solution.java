package Sorting._0220_Contains_Duplicate_III;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, w = t + 1;
        for (int i = 0; i < n; i++) {
            int id = getID(nums[i], w);
            if (map.containsKey(id))
                return true;
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w)
                return true;
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w)
                return true;
            map.put(id, nums[i]);
            if (i >= k)
                map.remove(getID(nums[i - k], w));
        }
        return false;
    }

    private int getID(int x, int w) {
        return (x < 0) ? (x + 1) / w - 1 : x / w;
    }
}
