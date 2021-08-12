package BinarySearch._0240_Search_a_2D_Matrix_II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int r = m - 1, c = 0;
        while (r >= 0 && c < n) {
            if (matrix[r][c] < target) {
                c++;
            } else if (matrix[r][c] > target) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrixBinarySearch(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int shorterDim = Math.min(m, n);
        for (int i = 0; i < shorterDim; i++) {
            if (binarySearch(matrix, target, i, true) || binarySearch(matrix, target, i, false))
                return true;
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int m = matrix.length, n = matrix[0].length;
        int l = start, r = vertical ? m - 1 : n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (vertical) {
                if (matrix[mid][start] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (matrix[start][mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return vertical ? matrix[l][start] == target : matrix[start][l] == target;
    }
}
