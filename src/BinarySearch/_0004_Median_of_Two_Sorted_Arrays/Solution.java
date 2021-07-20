package BinarySearch._0004_Median_of_Two_Sorted_Arrays;

public class Solution {
    public double findMedianSortedArraysMerge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int cnt = 0, i = 0, j = 0;
        int[] nums = new int[m + n];
        while (cnt < (m + n)) {
            if (i == m) {
                while (j < n) {
                    nums[cnt++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i < m) {
                    nums[cnt++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[cnt++] = nums1[i++];
            } else {
                nums[cnt++] = nums2[j++];
            }
        }
        return ((cnt & 1) == 1) ? (double) nums[cnt / 2] : (nums[cnt / 2] + nums[cnt / 2 - 1]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, cnt = m + n;
        if ((cnt & 1) == 1)
            return (double) getKth(nums1, 0, m, nums2, 0, n, (cnt + 1) / 2);
        return (getKth(nums1, 0, m, nums2, 0, n, cnt / 2) + getKth(nums1, 0, m, nums2, 0, n, cnt / 2 + 1)) / 2.0;
    }

    private int getKth(int[] nums1, int i1, int j1, int[] nums2, int i2, int j2, int k) {
        int len1 = j1 - i1;
        int len2 = j2 - i2;
        if (len1 > len2) return getKth(nums2, i2, j2, nums1, i1, j1, k);
        if (len1 == 0) return nums2[i2 + k - 1];
        if (k == 1) return Math.min(nums1[i1], nums2[i2]);

        int idx1 = Math.min(j1 - 1, i1 + k / 2 - 1);
        int idx2 = i2 + k / 2 - 1;
        if (nums1[idx1] <= nums2[idx2]) {
            return getKth(nums1, idx1 + 1, j1, nums2, i2, j2, k - (idx1 - i1 + 1));
        } else {
            return getKth(nums1, i1, j1, nums2, idx2 + 1, j2, k - (idx2 - i2 + 1));
        }
    }

    public double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;
        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
