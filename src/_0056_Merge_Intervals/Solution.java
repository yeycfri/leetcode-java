package _0056_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                ans.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        ans.add(new int[]{left, right});
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}
        };
        System.out.println(Arrays.deepToString(solution.merge(input)));
    }
}
