package Design._0208_Implement_Trie_Prefix_Tree;

public class Trie {

    private boolean isEnd;
    private Trie[] next;

    private void end() {
        isEnd = true;
    }

    private boolean isEnd() {
        return isEnd;
    }

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.next[c - 'a'] == null)
                t.next[c - 'a'] = new Trie();
            t = t.next[c - 'a'];
        }
        t.end();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie t = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t.next[c - 'a'] == null)
                return false;
            t = t.next[c - 'a'];
        }
        return t.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie t = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (t.next[c - 'a'] == null)
                return false;
            t = t.next[c - 'a'];
        }
        return true;
    }
}
