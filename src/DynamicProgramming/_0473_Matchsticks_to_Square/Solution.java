package DynamicProgramming._0473_Matchsticks_to_Square;

import java.util.Arrays;

public class Solution {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0, n = matchsticks.length;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[n - 1] > target) return false;

        int mask = 1 << n;
        boolean[] dp = new boolean[mask];
        dp[0] = true;
        int[] curSum = new int[mask];
        for (int i = 0; i < mask; i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) continue;
                int next = i | (1 << j);
                if (dp[next]) continue;
                if (matchsticks[j] + curSum[i] % target <= target) {
                    dp[next] = true;
                    curSum[next] = curSum[i] + matchsticks[j];
                } else {
                    break;
                }
            }
        }
        return dp[mask - 1];
    }

    public boolean makesquareDFS(int[] matchsticks) {
        int sum = 0, n = matchsticks.length;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        if (matchsticks[n - 1] > target) return false;
        return backtracking(matchsticks, n, new int[4], 4, target, n - 1);
    }

    private boolean backtracking(int[] matchsticks, int n, int[] bucket, int k, int target, int cur) {
        if (cur < 0) return true;

        for (int i = 0; i < 4; i++) {
            if (bucket[i] == target) continue;
            if (bucket[i] + matchsticks[cur] > target) continue;
            bucket[i] += matchsticks[cur];
            if (backtracking(matchsticks, n, bucket, k, target, cur - 1)) return true;
            bucket[i] -= matchsticks[cur];
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makesquare(new int[]{5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4}));
    }
}
