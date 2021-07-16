package DynamicProgramming._0698_Partition_to_K_Equal_Sum_Subsets;

import java.util.Arrays;

public class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;

        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[n - 1] > target) return false;

        int mask = 1 << n;
        boolean[] dp = new boolean[mask];
        int[] curSum = new int[mask];
        dp[0] = true;
        for (int i = 0; i < mask; i++) {
            if (!dp[i]) continue;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) continue;
                int next = i | (1 << j);
                if (dp[next]) continue;
                if (nums[j] + (curSum[i] % target) <= target) {
                    dp[next] = true;
                    curSum[next] = curSum[i] + nums[j];
                } else {
                    break;
                }
            }
        }
        return dp[mask - 1];
    }

    public boolean canPartitionKSubsetsDFS(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[n - 1] > target) return false;
        return backtracking(nums, n, new boolean[n], k, target, 0);
    }

    private boolean backtracking(int[] nums, int n, boolean[] used, int k, int target, int sum) {
        if (k == 1) return true;
        if (sum == target) return backtracking(nums, n, used, k - 1, target, 0);

        for (int i = n - 1; i >= 0; i--) {
            if (used[i]) continue;
            if (sum + nums[i] > target) continue;
            used[i] = true;
            if (backtracking(nums, n, used, k, target, sum + nums[i])) return true;
            used[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
//        System.out.println(solution.canPartitionKSubsets(new int[]{3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269}, 5));
    }
}
