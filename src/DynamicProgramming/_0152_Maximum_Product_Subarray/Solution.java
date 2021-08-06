package DynamicProgramming._0152_Maximum_Product_Subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxF, min = minF;
            maxF = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            minF = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }
}
