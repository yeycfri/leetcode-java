package _0977_Squares_of_a_Sorted_Array;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, left = 0, right = n - 1, cur = n - 1;
        int[] ans = new int[nums.length];
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                ans[cur] = nums[right] * nums[right];
                right--;
            } else {
                ans[cur] = nums[left] * nums[left];
                left++;
            }
            cur--;
        }
        return ans;
    }
}
