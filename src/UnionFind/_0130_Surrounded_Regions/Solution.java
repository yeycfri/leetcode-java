package UnionFind._0130_Surrounded_Regions;

import common.UnionFind;

import java.util.Arrays;

public class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int dummy = m * n;
        UnionFind uf = new UnionFind(dummy + 1);

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') uf.union(dummy, i * n);
            if (board[i][n - 1] == 'O') uf.union(dummy, i * n + n - 1);
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') uf.union(dummy, i);
            if (board[m - 1][i] == 'O') uf.union(dummy, (m - 1) * n + i);
        }

        int[] dir = new int[]{-1, 0, 1, 0, -1};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k];
                        int y = j + dir[k + 1];
                        if (board[x][y] == 'O') uf.union(i * n + j, x * n + y);
                    }
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solveDFS(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (board[i][j] != 'O') return;
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            dfs(board, i + dir[k], j + dir[k + 1]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'X', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
