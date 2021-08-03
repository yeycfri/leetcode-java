package TwoPointers._0611_Valid_Triangle_Number;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length, ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1, k = j; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    k++;
                }
                ans += k - j;
            }
        }
        return ans;
    }
}
