package Sorting.LCCI_10_01_Sorted_Merge;

public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, cur = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] <= B[j]) A[cur--] = B[j--];
            else A[cur--] = A[i--];
        }
        while (j >= 0) A[cur--] = B[j--];
    }
}
