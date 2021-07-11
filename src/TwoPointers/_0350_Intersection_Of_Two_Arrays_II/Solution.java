package TwoPointers._0350_Intersection_Of_Two_Arrays_II;

import java.util.*;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        int[] ans = new int[nums1.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);
    }

    public int[] intersectMap(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[nums1.length];
        int i = 0;
        for (int num : nums2) {
            if (!map.containsKey(num)) {
                continue;
            }
            int remain = map.get(num) - 1;
            if (remain >= 0) {
                ans[i++] = num;
                map.put(num, remain);
            }
        }
        return Arrays.copyOfRange(ans, 0, i);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersectMap(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(new Solution().intersectMap(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
