package SlidingWindow._0209_Minimum_Size_Subarray_Sum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, left = 0, right = 0;
        int sum = 0, ans = Integer.MAX_VALUE;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
