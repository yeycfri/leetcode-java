package UnionFind._0128_Longest_Consecutive_Sequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class UF {

        Map<Integer, Integer> parent;
        Map<Integer, Integer> size;

        public UF(int[] nums) {
            parent = new HashMap<>();
            size = new HashMap<>();
            for (int num : nums) {
                parent.put(num, num);
                size.put(num, 1);
            }
        }

        public void union(int p, int q) {
            int rp = find(p);
            int rq = find(q);
            if (rp == rq) return;

            if (size.get(rp) > size.get(rq)) {
                parent.put(rq, rp);
                size.put(rp, size.get(rp) + size.get(rq));
            } else {
                parent.put(rp, rq);
                size.put(rq, size.get(rp) + size.get(rq));
            }
        }

        public int find(int x) {
            if (!parent.containsKey(x))
                return Integer.MIN_VALUE;

            while (x != parent.get(x)) {
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }

        public int size(int x) {
            int root = find(x);
            return root == Integer.MIN_VALUE ? 0 : size.get(root);
        }
    }

    public int longestConsecutive(int[] nums) {
        UF uf = new UF(nums);
        for (int num : nums) {
            if (uf.size(num + 1) != 0) uf.union(num, num + 1);
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, uf.size(num));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
