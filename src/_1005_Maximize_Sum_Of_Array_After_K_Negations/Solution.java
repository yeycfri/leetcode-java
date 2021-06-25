package _1005_Maximize_Sum_Of_Array_After_K_Negations;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            if (k > 0 && num < 0) {
                num = -num;
                k--;
            }
            sum += num;
            min = Math.min(min, num);
        }
        return (k % 2 != 0) ? sum - min * 2 : sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(solution.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
        System.out.println(solution.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
    }
}
