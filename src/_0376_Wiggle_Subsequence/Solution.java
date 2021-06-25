package _0376_Wiggle_Subsequence;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int result = 1;
        int curDiff = 0;
        int preDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff < 0 && preDiff >= 0) || (curDiff > 0 && preDiff <= 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
    }
}
