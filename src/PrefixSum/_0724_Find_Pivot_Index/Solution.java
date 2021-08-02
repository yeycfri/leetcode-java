package PrefixSum._0724_Find_Pivot_Index;

public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] P = new int[n + 1];
        for (int i = 0; i < n; i++) P[i + 1] = P[i] + nums[i];

        for (int i = 0; i < n; i++) {
            if (P[i] == P[n] - P[i + 1])
                return i;
        }
        return -1;
    }
}
