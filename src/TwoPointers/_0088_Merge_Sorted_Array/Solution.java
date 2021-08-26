package TwoPointers._0088_Merge_Sorted_Array;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, idx = m + n - 1;
        while (idx >= 0) {
            if (p1 < 0) {
                nums1[idx--] = nums2[p2--];
                continue;
            }
            if (p2 < 0) {
                nums1[idx--] = nums1[p1--];
                continue;
            }
            if (nums1[p1] > nums2[p2]) {
                nums1[idx--] = nums1[p1--];
            } else {
                nums1[idx--] = nums2[p2--];
            }
        }
    }
}
