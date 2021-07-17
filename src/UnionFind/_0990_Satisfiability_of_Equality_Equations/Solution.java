package UnionFind._0990_Satisfiability_of_Equality_Equations;

import common.UnionFind;

public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String str : equations) {
            if (str.charAt(1) == '=') uf.union(str.charAt(0) - 'a', str.charAt(3) - 'a');
        }
        for (String str : equations) {
            if (str.charAt(1) == '!' && uf.connected(str.charAt(0) - 'a', str.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }
}
