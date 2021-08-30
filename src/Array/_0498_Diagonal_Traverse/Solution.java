package Array._0498_Diagonal_Traverse;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] arr = new int[m * n];
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mat[x][y];
            if (((x + y) & 1) == 0) {
                if (y == n - 1) {
                    x++;
                } else if (x == 0) {
                    y++;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (x == m - 1) {
                    y++;
                } else if (y == 0) {
                    x++;
                } else {
                    x++;
                    y--;
                }
            }
        }
        return arr;
    }
}
