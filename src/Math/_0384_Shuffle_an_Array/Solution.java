package Math._0384_Shuffle_an_Array;

import java.util.Random;

public class Solution {
    int[] orignal;
    int[] arr;
    int n;
    Random r;

    public Solution(int[] nums) {
        n = nums.length;
        orignal = nums;
        arr = orignal.clone();
        r = new Random();
    }

    public int[] reset() {
        return orignal;
    }

    public int[] shuffle() {
        for (int i = arr.length; i > 0; i--)
            swap(arr, i - 1, r.nextInt(i));
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
