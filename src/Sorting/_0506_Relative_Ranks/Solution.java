package Sorting._0506_Relative_Ranks;

import java.util.Arrays;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[][] rank = new int[n][2];
        for (int i = 0; i < n; i++) {
            rank[i][0] = score[i];
            rank[i][1] = i;
        }
        Arrays.sort(rank, (o1, o2) -> Integer.compare(o2[0], o1[0]));
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[rank[i][1]] = title(i + 1);
        }
        return ans;
    }

    private String title(int rank) {
        switch (rank) {
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return String.valueOf(rank);
        }
    }

    public String[] findRelativeRanksCounting(int[] score) {
        int n = score.length;

        int max = 0;
        for (int s : score) {
            max = Math.max(max, s);
        }

        int[] arr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            arr[score[i]] = i + 1;
        }

        String[] ans = new String[n];
        int rank = 1;
        for (int i = max; i >= 0; i--) {
            if (arr[i] == 0) continue;
            ans[arr[i] - 1] = title(rank++);
        }

        return ans;
    }
}
