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
}
