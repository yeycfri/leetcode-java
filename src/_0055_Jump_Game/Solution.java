package _0055_Jump_Game;

public class Solution {
    public boolean canJump(int[] nums) {
        int cover = nums[0];
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= (nums.length - 1)) return true;
        }
        return false;
    }
}
