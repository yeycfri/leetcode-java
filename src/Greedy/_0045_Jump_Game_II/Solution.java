package Greedy._0045_Jump_Game_II;

public class Solution {
    public int jump(int[] nums) {
        int ans = 0, curCover = 0, nextCover = 0;
        for (int i = 0; i < (nums.length - 1); i++) {
            nextCover = Math.max(nextCover, i + nums[i]);
            if (i == curCover) {
                ans++;
                curCover = nextCover;
            }
        }
        return ans;
    }
}
