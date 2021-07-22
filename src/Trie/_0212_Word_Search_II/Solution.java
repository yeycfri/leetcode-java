package Trie._0212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class Trie {
        Trie[] next;
        String word;

        Trie() {
            next = new Trie[26];
        }

        public void add(String word) {
            Trie t = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (t.next[c - 'a'] == null)
                    t.next[c - 'a'] = new Trie();
                t = t.next[c - 'a'];
            }
            t.word = word;
        }

        public boolean nextHas(char c) {
            return next[c - 'a'] != null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        List<String> ans = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trie.nextHas(board[i][j]))
                    dfs(board, i, j, trie, ans);
            }
        }
        return ans;
    }

    int[] dir = new int[]{-1, 0, 1, 0, -1};

    private void dfs(char[][] board, int i, int j, Trie trie, List<String> ans) {
        char ch = board[i][j];
        Trie cur = trie.next[ch - 'a'];
        if (cur.word != null) {
            ans.add(cur.word);
            cur.word = null;
        }

        board[i][j] = '#';
        int m = board.length, n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k], y = j + dir[k + 1];
            if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == '#') continue;
            if (cur.nextHas(board[x][y]))
                dfs(board, x, y, cur, ans);
        }
        board[i][j] = ch;

        if (cur.next == null) trie.next[ch - 'a'] = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                new char[]{'o', 'a', 'a', 'n'},
                new char[]{'e', 't', 'a', 'e'},
                new char[]{'i', 'h', 'k', 'r'},
                new char[]{'i', 'f', 'l', 'v'},
        };
        System.out.println(solution.findWords(board, new String[]{"oath", "pea", "eat", "rain"}));
    }
}
