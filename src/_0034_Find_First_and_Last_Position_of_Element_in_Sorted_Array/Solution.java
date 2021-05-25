package _0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        return new int[]{left, right};
    }

    public int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (nums[left] == target) ? left : -1;
    }

    public int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1) + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (nums[left] == target) ? left : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 9)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 12)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 1)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1}, 1)));
    }
}
