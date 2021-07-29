package Sorting._1122_Relative_Sort_Array;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int min = arr1[0], max = arr1[0], m = arr1.length, n = arr2.length;
        for (int num : arr1) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int range = max - min + 1;
        int[] counting = new int[range];
        for (int num : arr1) {
            counting[num - min]++;
        }
        int cur = 0;
        int[] ans = new int[m];
        for (int k : arr2) {
            for (int j = 0; j < counting[k - min]; j++) {
                ans[cur++] = k;
            }
            counting[k - min] = 0;
        }
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < counting[i]; j++) {
                ans[cur++] = i + min;
            }
        }
        return ans;
    }
}
