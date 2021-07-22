package Trie._0211_Design_Add_and_Search_Words_Data_Structure;

class WordDictionary {

    private boolean isEnd;
    private WordDictionary[] next;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        next = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary w = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (w.next[c - 'a'] == null)
                w.next[c - 'a'] = new WordDictionary();
            w = w.next[c - 'a'];
        }
        w.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, word.length(), 0, this);
    }

    private boolean dfs(String word, int n, int idx, WordDictionary w) {
        if (w == null) return false;
        if (idx == n) return w.isEnd;
        char c = word.charAt(idx);
        if (c != '.')
            return dfs(word, n, idx + 1, w.next[c - 'a']);

        for (int i = 0; i < 26; i++) {
            if (dfs(word, n, idx + 1, w.next[i])) return true;
        }
        return false;
    }
}
