package Sorting._0912_Sort_an_Array;

import java.util.Arrays;

public class Solution {

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    public int[] sortArrayBubble(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swaped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swaped = true;
                    swap(nums, j, j + 1);
                }
            }
            if (!swaped) break;
        }
        return nums;
    }

    public int[] sortArraySelect(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }
            swap(nums, minIdx, i);
        }
        return nums;
    }

    public int[] sortArrayInsert(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = num;
        }
        return nums;
    }

    public int[] sortArrayShell(int[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int num = nums[i];
                int j = i - gap;
                while (j >= 0 && num < nums[j]) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = num;
            }
        }
        return nums;
    }

    public int[] sortArrayHeap(int[] nums) {
        buildHeap(nums);
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums;
    }

    private void buildHeap(int[] nums) {
        int n = nums.length;
        for (int i = (n >> 1) - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }
    }

    private void heapify(int[] nums, int i, int size) {
        int l = (i << 1) + 1, r = l + 1, large = i;
        if (l < size && nums[l] > nums[large]) {
            large = l;
        }
        if (r < size && nums[r] > nums[large]) {
            large = r;
        }
        if (large != i) {
            swap(nums, large, i);
            heapify(nums, large, size);
        }
    }

    public int[] sortArrayQuick(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int i = l, j = r, p = l + ((r - l) >> 1);
        swap(arr, l, p);
        int x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) j--;
            if (i < j) arr[i] = arr[j];
            while (i < j && arr[i] <= x) i++;
            if (i < j) arr[j] = arr[i];
        }
        arr[i] = x;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    public int[] sortArrayMerge(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] arr, int l, int r, int[] temp) {
        if (l >= r) return;
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);
        merge(arr, l, mid, r, temp);
    }

    private void merge(int[] arr, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1, t = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[t++] = arr[i++];
            else temp[t++] = arr[j++];
        }
        while (i <= mid) temp[t++] = arr[i++];
        while (j <= r) temp[t++] = arr[j++];
        t = 0;
        while (l <= r) arr[l++] = temp[t++];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayBubble(new int[]{1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArraySelect(new int[]{1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArrayInsert(new int[]{1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArrayShell(new int[]{1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArrayHeap(new int[]{1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArrayQuick(new int[]{1, 5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArrayMerge(new int[]{1, 5, 2, 3, 1})));
    }
}
