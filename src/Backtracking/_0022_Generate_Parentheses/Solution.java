package Backtracking._0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        dfs(str, n, n, ans);
        return ans;
    }

    private void dfs(StringBuilder sb, int l, int r, List<String> ans) {
        if (l == 0 && r == 0)
            ans.add(sb.toString());
        if (l > r)
            return;
        if (l > 0) {
            dfs(sb.append('('), l - 1, r, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r > 0) {
            dfs(sb.append(')'), l, r - 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
