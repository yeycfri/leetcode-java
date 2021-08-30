package Heap._0239_Sliding_Window_Maximum;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
        int n = nums.length;
        for (int i = 0; i < k - 1; i++) {
            heap.offer(new int[]{nums[i], i});
        }
        int[] arr = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            while (!heap.isEmpty() && heap.peek()[1] <= (i - k)) {
                heap.poll();
            }
            heap.offer(new int[]{nums[i], i});
            arr[i - k + 1] = heap.peek()[0];
        }
        return arr;
    }
}
