package Sorting.LCOF_51_Shu_Zu_Zhong_De_Ni_Xu_Dui;

public class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return count(nums, 0, nums.length - 1, temp);
    }

    private int count(int[] nums, int l, int r, int[] temp) {
        if (l >= r) return 0;
        int mid = l + ((r - l) >> 1);
        return count(nums, l, mid, temp) + count(nums, mid + 1, r, temp) + merge(nums, l, mid, r, temp);
    }

    private int merge(int[] nums, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1, cur = 0, cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[cur++] = nums[i++];
            } else {
                temp[cur++] = nums[j++];
                cnt += mid - i + 1;
            }
        }
        while (i <= mid) temp[cur++] = nums[i++];
        while (j <= r) temp[cur++] = nums[j++];
        for (cur = 0; l <= r; ) nums[l++] = temp[cur++];
        return cnt;
    }
}
