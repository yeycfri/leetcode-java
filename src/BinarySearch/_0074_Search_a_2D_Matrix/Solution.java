package BinarySearch._0074_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (matrix[mid / n][mid % n] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return matrix[l / n][l % n] == target;
    }
}
