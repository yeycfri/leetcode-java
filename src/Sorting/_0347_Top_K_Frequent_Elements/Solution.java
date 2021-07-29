package Sorting._0347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int n = map.size(), idx = 0;
        int[][] arr = new int[n][2];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            arr[idx][0] = e.getKey();
            arr[idx][1] = e.getValue();
            idx++;
        }
        int[] ans = new int[k];
        quickselect(arr, 0, n - 1, k, ans, 0);
        return ans;
    }

    private void quickselect(int[][] arr, int l, int r, int k, int[] ans, int ansIdx) {
        if (l > r) return;
        int i = l, j = r, p = l + ((r - l) >> 1);
        swap(arr, l, p);
        while (i < j) {
            while (i < j && arr[j][1] <= arr[l][1]) j--;
            while (i < j && arr[i][1] >= arr[l][1]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        int leftNum = i - l + 1;
        if (k < leftNum) {
            quickselect(arr, l, i - 1, k, ans, ansIdx);
        } else {
            for (int ii = l; ii <= i; ii++)
                ans[ansIdx++] = arr[ii][0];
            if (k > leftNum)
                quickselect(arr, i + 1, r, k - leftNum, ans, ansIdx);
        }
    }

    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
