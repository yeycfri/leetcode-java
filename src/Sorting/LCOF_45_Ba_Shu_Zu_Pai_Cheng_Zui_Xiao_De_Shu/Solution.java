package Sorting.LCOF_45_Ba_Shu_Zu_Pai_Cheng_Zui_Xiao_De_Shu;

import java.util.Arrays;

public class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder ans = new StringBuilder();
        for (String str : strs)
            ans.append(str);
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
