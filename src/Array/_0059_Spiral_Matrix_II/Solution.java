package Array._0059_Spiral_Matrix_II;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cur = 1, size = n * n;

        int row1 = 0, row2 = n - 1, col1 = 0, col2 = n - 1;
        while (cur <= size) {
            for (int i = col1; i <= col2; i++) {
                ans[row1][i] = cur++;
            }
            row1++;
            for (int i = row1; i <= row2; i++) {
                ans[i][col2] = cur++;
            }
            col2--;
            for (int i = col2; i >= col1; i--) {
                ans[row2][i] = cur++;
            }
            row2--;
            for (int i = row2; i >= row1; i--) {
                ans[i][col1] = cur++;
            }
            col1++;
        }
        return ans;
    }
}
