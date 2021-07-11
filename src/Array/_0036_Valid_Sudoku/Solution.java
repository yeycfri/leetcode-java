package Array._0036_Valid_Sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] grid = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            grid[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                if (board[i][j] != '.') continue;
                if (!row.add(board[i][j])) return false;
                if (!grid[(i / 3) * 3 + j / 3].add(board[i][j])) return false;
            }
        }
        return true;
    }
}
