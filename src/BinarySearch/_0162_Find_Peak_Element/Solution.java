package BinarySearch._0162_Find_Peak_Element;

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return n - 1;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
