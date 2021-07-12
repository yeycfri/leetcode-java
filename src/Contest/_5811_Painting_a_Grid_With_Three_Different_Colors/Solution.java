package Contest._5811_Painting_a_Grid_With_Three_Different_Colors;

import java.util.*;

public class Solution {
    private static final int MOD = (int) (1e9 + 7);
    private static final int[] COLOR = new int[]{1, 2, 3};

    public int colorTheGrid(int m, int n) {
        List<Integer> valid = new ArrayList<>();
        dfs(valid, 0, 0, m);

        Map<Integer, List<Integer>> pair = new HashMap<>();
        for (int mask1 : valid) {
            for (int mask2 : valid) {
                if (check(mask1, mask2, m)) {
                    List<Integer> nums = pair.getOrDefault(mask1, new ArrayList<>());
                    nums.add(mask2);
                    pair.put(mask1, nums);
                }
            }
        }

        int[][] dp = new int[n][1 << (2 * m)];
        for (int mask : valid) {
            dp[0][mask] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int mask1 : valid) {
                for (int mask2 : pair.get(mask1)) {
                    dp[i][mask2] += dp[i - 1][mask1];
                    dp[i][mask2] %= MOD;
                }
            }
        }
        int ans = 0;
        for (int mask : valid) {
            ans += dp[n - 1][mask];
            ans %= MOD;
        }
        return ans;
    }

    private void dfs(List<Integer> valid, int cur, int i, int m) {
        if (i == m) {
            valid.add(cur);
            return;
        }
        for (int c : COLOR) {
            int prev = cur & 3;
            if (prev == c) continue;
            dfs(valid, (cur << 2) | c, i + 1, m);
        }
    }

    private boolean check(int mask1, int mask2, int m) {
        for (int i = 0; i < m; i++) {
            if ((mask1 & 3) == (mask2 & 3)) return false;
            mask1 >>= 2;
            mask2 >>= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.colorTheGrid(1, 1));
        System.out.println(solution.colorTheGrid(1, 2));
        System.out.println(solution.colorTheGrid(2, 1));
        System.out.println(solution.colorTheGrid(5, 5));
        System.out.println(solution.colorTheGrid(2, 37));
    }
}
