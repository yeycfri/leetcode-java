package Heap.LCOF_40_Zui_Xiao_De_K_Ge_Shu;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[]{};

        int n = arr.length;
        for (int i = (n >> 1) - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[0];
            swap(arr, 0, n - 1 - i);
            heapify(arr, 0, n - 1 - i);
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private void heapify(int[] arr, int i, int size) {
        int l = (i << 1) + 1, r = l + 1, small = i;
        if (l < size && arr[l] < arr[small]) {
            small = l;
        }
        if (r < size && arr[r] < arr[small]) {
            small = r;
        }
        if (small != i) {
            swap(arr, i, small);
            heapify(arr, small, size);
        }
    }
}
