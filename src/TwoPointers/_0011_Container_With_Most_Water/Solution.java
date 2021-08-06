package TwoPointers._0011_Container_With_Most_Water;

public class Solution {
    public int maxArea(int[] height) {
        int n = height.length, l = 0, r = n - 1, ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}
