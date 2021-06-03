package _0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;

        int row1 = 0, row2 = m - 1, col1 = 0, col2 = n - 1;
        int size = m * n, cur = 1;

        while (cur <= size) {
            for (int i = col1; i <= col2 && cur <= size; i++) {
                ans.add(matrix[row1][i]);
                cur++;
            }
            row1++;
            for (int i = row1; i <= row2 && cur <= size; i++) {
                ans.add(matrix[i][col2]);
                cur++;
            }
            col2--;
            for (int i = col2; i >= col1 && cur <= size; i--) {
                ans.add(matrix[row2][i]);
                cur++;
            }
            row2--;
            for (int i = row2; i >= row1 && cur <= size; i--) {
                ans.add(matrix[i][col1]);
                cur++;
            }
            col1++;
        }
        return ans;
    }
}
