package Sorting._0164_Maximum_Gap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        radixSort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    private void radixSort(int[] arr) {
        int max = 0, maxDigitLen = 0;
        for (int val : arr)
            max = Math.max(max, val);
        while (max != 0) {
            maxDigitLen++;
            max /= 10;
        }

        int n = arr.length, dev = 1;
        int[] counting = new int[10], temp = new int[n];
        for (int i = 0; i < maxDigitLen; i++) {
            for (int val : arr) {
                int radix = val / dev % 10;
                counting[radix]++;
            }
            for (int j = 1; j < 10; j++)
                counting[j] += counting[j - 1];
            for (int j = n - 1; j >= 0; j--) {
                int radix = arr[j] / dev % 10;
                temp[--counting[radix]] = arr[j];
            }
            System.arraycopy(temp, 0, arr, 0, n);
            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }

    // use bucket sort
    public int maximumGapBucket(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int val : nums) {
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        if (max == min) return 0;

        int n = nums.length;
        int interval = (max - min) / n + 1;
        int[] bucketMin = new int[n + 1];
        int[] bucketMax = new int[n + 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            int bIdx = (num - min) / interval;
            bucketMin[bIdx] = Math.min(bucketMin[bIdx], num);
            bucketMax[bIdx] = Math.max(bucketMax[bIdx], num);
        }
        int preMax = min, ans = 0;
        for (int i = 0; i < n + 1; i++) {
            if (bucketMax[i] == Integer.MIN_VALUE) continue;
            ans = Math.max(ans, bucketMin[i] - preMax);
            preMax = bucketMax[i];
        }
        return ans;
    }
}
