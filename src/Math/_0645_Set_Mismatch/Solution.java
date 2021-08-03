package Math._0645_Set_Mismatch;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length, sum = 0, sumdup = 0;
        int[] set = new int[n + 1];
        for (int x : nums) {
            sumdup += x;
            sum += set[x] >= 1 ? 0 : x;
            set[x]++;
        }
        int[] ans = new int[2];
        ans[0] = sumdup - sum;
        ans[1] = (1 + n) * n / 2 - sum;
        return ans;
    }

    public int[] findErrorNumsMapping(int[] nums) {
        int dup = -1, miss = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[idx] *= -1;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) miss = i + 1;
        }
        return new int[]{dup, miss};
    }
}
