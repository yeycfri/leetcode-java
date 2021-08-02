package PrefixSum._0974_Subarray_Sums_Divisible_by_K;

public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k];
        map[0] = 1;
        int cnt = 0, sum = 0;
        for (int x : nums) {
            sum += x;
            int mod = (sum % k + k) % k;
            cnt += map[mod];
            map[mod]++;
        }
        return cnt;
    }
}
