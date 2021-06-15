package _0347_Top_K_Frequent_Elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(nums);
        int idx = 0;
        while (idx < nums.length) {
            int count = 1;
            while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
                idx++;
                count++;
            }

            if (pq.size() < k) {
                pq.offer(new int[]{nums[idx], count});
            } else if (pq.peek()[1] < count) {
                pq.poll();
                pq.offer(new int[]{nums[idx], count});
            }
            idx++;
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
