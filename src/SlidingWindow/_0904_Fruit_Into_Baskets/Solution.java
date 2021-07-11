package SlidingWindow._0904_Fruit_Into_Baskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int totalFruit(int[] tree) {
        int n = tree.length;
        int ans = Integer.MIN_VALUE;
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) map.remove(tree[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
