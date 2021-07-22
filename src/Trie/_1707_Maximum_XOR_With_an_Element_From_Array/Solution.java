package Trie._1707_Maximum_XOR_With_an_Element_From_Array;

import java.util.Arrays;

public class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        int[][] nq = new int[n][3];
        for (int i = 0; i < n; i++) {
            nq[i][0] = queries[i][0];
            nq[i][1] = queries[i][1];
            nq[i][2] = i;
        }
        Arrays.sort(nq, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        Trie t = new Trie();
        int[] ans = new int[n];
        int m = nums.length, idx = 0;
        for (int[] q : nq) {
            while (idx < m && nums[idx] <= q[1]) {
                t.add(nums[idx++]);
            }
            if (idx == 0) {
                ans[q[2]] = -1;
            } else {
                ans[q[2]] = t.getVal(q[0]);
            }
        }
        return ans;
    }

    class Trie {
        private static final int L = 30;
        private Trie[] next;

        Trie() {
            next = new Trie[2];
        }

        public void add(int x) {
            Trie t = this;
            for (int i = L - 1; i >= 0; i--) {
                int a = (x >> i) & 1;
                if (t.next[a] == null)
                    t.next[a] = new Trie();
                t = t.next[a];
            }
        }

        public int getVal(int x) {
            int val = 0;
            Trie t = this;
            for (int i = L - 1; i >= 0; i--) {
                int bit = (x >> i) & 1;
                if (t.next[bit ^ 1] != null) {
                    val |= 1 << i;
                    bit ^= 1;
                }
                t = t.next[bit];
            }
            return val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 2, 4, 6, 6, 3};
        int[][] queries = new int[][]{
                new int[]{12, 4},
                new int[]{8, 1},
                new int[]{6, 3},
        };
        System.out.println(Arrays.toString(solution.maximizeXor(nums, queries)));
    }
}
