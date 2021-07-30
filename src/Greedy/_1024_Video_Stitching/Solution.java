package Greedy._1024_Video_Stitching;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? Integer.compare(o2[1], o1[1]) : Integer.compare(o1[0], o2[0]);
            }
        });
        if (clips[0][0] != 0) return -1;

        int n = clips.length, cur = clips[0][1], ans = 1, i = 1;
        while (i < n) {
            if (cur >= time) return ans;
            if (clips[i][0] > cur) break;
            int extend = cur;
            while (i < n && clips[i][0] <= cur) {
                extend = Math.max(extend, clips[i][1]);
                i++;
            }
            cur = extend;
            ans++;
        }
        return cur >= time ? ans : -1;
    }

    public int videoStitchingDP(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, 101);
        dp[0] = 0;
        for (int i = 0; i < time + 1; i++) {
            for (int[] clip : clips) {
                if (i > clip[0] && i <= clip[1])
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
            }
        }
        return dp[time] == 101 ? -1 : dp[time];
    }
}
