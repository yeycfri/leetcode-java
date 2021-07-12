package Contest._5808_Concatenation_of_Array;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            ans[i] = nums[i % n];
        }
        return ans;
    }
}
