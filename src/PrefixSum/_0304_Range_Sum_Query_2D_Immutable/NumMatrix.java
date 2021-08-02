package PrefixSum._0304_Range_Sum_Query_2D_Immutable;

public class NumMatrix {
    int[][] P;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        P = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                P[i + 1][j + 1] = P[i + 1][j] + P[i][j + 1] - P[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return P[row2 + 1][col2 + 1] + P[row1][col1] - P[row1][col2 + 1] - P[row2 + 1][col1];
    }
}
