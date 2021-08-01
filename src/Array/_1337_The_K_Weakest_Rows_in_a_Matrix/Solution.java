package Array._1337_The_K_Weakest_Rows_in_a_Matrix;

import java.util.Arrays;

public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        int[][] val = new int[n][2];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < m; j++) if (mat[i][j] == 0) break;
            val[i][0] = j;
            val[i][1] = i;
        }
        Arrays.sort(val, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = val[i][1];
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = new int[][]{
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 1, 1, 0},
                new int[]{1, 0, 0, 0, 0},
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1},
        };
        System.out.println(Arrays.toString(solution.kWeakestRows(mat, 3)));
    }
}
