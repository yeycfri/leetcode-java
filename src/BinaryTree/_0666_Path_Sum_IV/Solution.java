package BinaryTree._0666_Path_Sum_IV;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int ans;

    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        ans = 0;
        dfs(map, 11, 0);
        return ans;
    }

    private void dfs(Map<Integer, Integer> map, int cur, int sum) {
        if (!map.containsKey(cur)) return;
        sum += map.get(cur);

        int h = cur / 10, n = cur % 10;
        int left = (h + 1) * 10 + n * 2 - 1, right = (h + 1) * 10 + n * 2;
        if (!map.containsKey(left) && !map.containsKey(right)) {
            ans += sum;
            return;
        }

        dfs(map, left, sum);
        dfs(map, right, sum);
    }
}
