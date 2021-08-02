package PrefixSum._0303_Range_Sum_Query_Immutable;

public class NumArray {
    int[] P;

    public NumArray(int[] nums) {
        P = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            P[i + 1] = P[i] + nums[i];
    }

    public int sumRange(int left, int right) {
        return P[right + 1] - P[left];
    }
}
