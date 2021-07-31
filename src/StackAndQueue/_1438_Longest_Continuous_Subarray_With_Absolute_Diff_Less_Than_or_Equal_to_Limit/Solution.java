package StackAndQueue._1438_Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class Solution {
    public int longestSubarrayTreeMap(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length, l = 0, r = 0, ans = 0;
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length, l = 0, r = 0, ans = 0;
        while (r < n) {
            while (!min.isEmpty() && min.peekLast() > nums[r])
                min.pollLast();
            while (!max.isEmpty() && max.peekLast() < nums[r])
                max.pollLast();
            min.offerLast(nums[r]);
            max.offerLast(nums[r]);
            while (max.peekFirst() - min.peekFirst() > limit) {
                if (nums[l] == max.peekFirst()) max.pollFirst();
                if (nums[l] == min.peekFirst()) min.pollFirst();
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }
}
