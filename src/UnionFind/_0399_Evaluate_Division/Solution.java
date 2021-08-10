package UnionFind._0399_Evaluate_Division;

import java.util.*;

public class Solution {

    class UF {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> factor = new HashMap<>();

        UF(List<List<String>> equations) {
            for (List<String> eq : equations) {
                String a = eq.get(0), b = eq.get(1);
                parent.put(a, a);
                parent.put(b, b);
                factor.put(a, 1.0);
                factor.put(b, 1.0);
            }
        }

        public String find(String x) {
            if (!parent.containsKey(x)) return null;

            double f = 1.0;
            String cur = x;
            while (!parent.get(cur).equals(cur)) {
                f *= factor.get(cur);
                cur = parent.get(cur);
            }
            parent.put(x, cur);
            factor.put(x, f);
            return cur;
        }

        public void union(String p, String q, double val) {
            String rp = find(p), rq = find(q);
            if (rp.equals(rq)) return;

            parent.put(rp, rq);
            factor.put(rp, val * factor.get(q) / factor.get(p));
        }

        public boolean connected(String p, String q) {
            String rp = find(p), rq = find(q);
            return rp != null && rp.equals(rq);
        }

        public double factor(String x) {
            return factor.get(x);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UF uf = new UF(equations);
        for (int i = 0; i < values.length; i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0), b = eq.get(1);
            uf.union(a, b, values[i]);
        }
        int n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; i++) {
            List<String> query = queries.get(i);
            String a = query.get(0), b = query.get(1);
            if (uf.connected(a, b)) {
                ans[i] = uf.factor(a) / uf.factor(b);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("x1", "x2"));
        equations.add(Arrays.asList("x2", "x3"));
        equations.add(Arrays.asList("x3", "x4"));
        equations.add(Arrays.asList("x4", "x5"));
        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("x1", "x5"));
        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}
