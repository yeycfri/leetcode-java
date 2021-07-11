package HashTable._0001_Two_Sum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sub;
        for (int i = 0; i < nums.length; i++) {
            sub = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(sub, i);
        }
        return null;
    }
}
