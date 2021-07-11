package Backtracking._0051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        char[][] board = new char[n][n];
        for (char[] r : board) Arrays.fill(r, '.');
        backtracking(board, cols, n, 0);
        return result;
    }

    private void backtracking(char[][] board, int[] cols, int n, int row) {
        if (row == n) {
            List<String> str = new ArrayList<>();
            for (char[] r : board) {
                str.add(new String(r));
            }
            result.add(str);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(cols, row, i)) continue;
            cols[row] = i;
            board[row][i] = 'Q';
            backtracking(board, cols, n, row + 1);
            board[row][i] = '.';
        }
    }

    private boolean isValid(int[] cols, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == cols[i]) return false;
            if (Math.abs(col - cols[i]) == (row - i)) return false;
        }
        return true;
    }
}
