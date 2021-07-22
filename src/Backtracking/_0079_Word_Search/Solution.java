package Backtracking._0079_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, visited)) return true;
            }
        }
        return false;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private boolean dfs(char[][] board, int r, int c, String word, int idx, boolean[][] visited) {
        if (board[r][c] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;

        visited[r][c] = true;
        int m = board.length, n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int x = r + dir[k], y = c + dir[k + 1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
            if (dfs(board, x, y, word, idx + 1, visited)) return true;
        }
        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'E', 'S'},
                new char[]{'A', 'D', 'E', 'E'},
        };
        System.out.println(solution.exist(board, "ABCEFSADEESE"));
    }
}
