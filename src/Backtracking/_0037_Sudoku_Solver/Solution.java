package Backtracking._0037_Sudoku_Solver;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int[] row = new int[9];
    int[] col = new int[9];
    int[][] blk = new int[3][3];
    List<int[]> toFill = new ArrayList<>(81);

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    flip(i, j, num);
                }
            }
        }

        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        int mask = ~(row[i] | col[j] | blk[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int num = Integer.bitCount(mask - 1);
                            board[i][j] = (char) ('1' + num);
                            flip(i, j, num);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) break;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    toFill.add(new int[]{i, j});
                }
            }
        }

        backtracking(board, 0);
    }

    private boolean backtracking(char[][] board, int pos) {
        if (pos == toFill.size()) {
            return true;
        }
        int[] position = toFill.get(pos);
        int pr = position[0], pc = position[1];
        int mask = ~(row[pr] | col[pc] | blk[pr / 3][pc / 3]) & 0x1ff;
        while (mask != 0) {
            int numIdx = mask & (-mask);
            int num = Integer.bitCount(numIdx - 1);

            board[pr][pc] = (char) ('1' + num);
            flip(pr, pc, num);
            if (backtracking(board, pos + 1)) return true;
            flip(pr, pc, num);

            mask ^= numIdx;
        }
        return false;
    }

    private void flip(int i, int j, int num) {
        row[i] ^= (1 << num);
        col[j] ^= (1 << num);
        blk[i / 3][j / 3] ^= (1 << num);
    }

}
