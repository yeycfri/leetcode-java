package Trie._0421_Maximum_XOR_of_Two_Numbers_in_an_Array;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int depth = 32 - Integer.numberOfLeadingZeros(max);

        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = depth - 1; i >= 0; i--) {
            ans <<= 1;
            int curPrefix = ans | 1;
            set.clear();
            for (int num : nums) {
                set.add(num >> i);
                if (set.contains(num >> i ^ curPrefix)) {
                    ans |= 1;
                    break;
                }
            }
        }
        return ans;
    }

    public int findMaximumXORTrie(int[] nums) {
        int n = nums.length, max = 0;
        Trie t = new Trie();
        for (int num : nums) {
            t.add(num);
            max = Math.max(max, num ^ t.getVal(num));
        }
        return max;
    }

    class Trie {
        private Trie[] next;

        Trie() {
            next = new Trie[2];
        }

        public void add(int x) {
            Trie t = this;
            for (int i = 31; i >= 0; i--) {
                int a = (x >> i) & 1;
                if (t.next[a] == null)
                    t.next[a] = new Trie();
                t = t.next[a];
            }
        }

        public int getVal(int x) {
            int val = 0;
            Trie t = this;
            for (int i = 31; i >= 0; i--) {
                int a = (x >> i) & 1, b = 1 - a;
                if (t.next[b] != null) {
                    val |= (b << i);
                    t = t.next[b];
                } else {
                    val |= (a << i);
                    t = t.next[a];
                }
            }
            return val;
        }
    }
}
