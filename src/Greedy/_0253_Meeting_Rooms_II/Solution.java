package Greedy._0253_Meeting_Rooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[][] updown = new int[n * 2][2];
        for (int i = 0; i < n * 2; i += 2) {
            updown[i][0] = intervals[i / 2][0];
            updown[i][1] = 1;
            updown[i + 1][0] = intervals[i / 2][1];
            updown[i + 1][1] = -1;
        }
        Arrays.sort(updown, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int cnt = 0, max = 0;
        for (int[] u : updown) {
            cnt += u[1];
            max = Math.max(cnt, max);
        }
        return max;
    }

    public int minMeetingRoomsHeap(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        Queue<int[]> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        for (int[] interval : intervals) {
            if (heap.isEmpty() || heap.peek()[1] > interval[0]) {
                heap.offer(interval);
            } else if (heap.peek()[1] <= interval[0]) {
                heap.poll();
                heap.offer(interval);
            }
        }
        return heap.size();
    }
}
