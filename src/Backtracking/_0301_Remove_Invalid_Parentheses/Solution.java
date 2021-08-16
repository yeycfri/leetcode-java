package Backtracking._0301_Remove_Invalid_Parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    char[] seq;
    Set<String> ans;
    StringBuilder path;

    public List<String> removeInvalidParentheses(String s) {
        seq = s.toCharArray();
        ans = new HashSet<>();
        path = new StringBuilder();
        int leftRemove = 0, rightRemove = 0;
        for (char ch : seq) {
            if (ch == '(') {
                leftRemove++;
            } else if (ch == ')') {
                if (leftRemove == 0) {
                    rightRemove++;
                } else {
                    leftRemove--;
                }
            }
        }
        dfs(0, 0, 0, leftRemove, rightRemove);
        return new ArrayList<>(ans);
    }

    private void dfs(int idx, int leftCount, int rightCount, int leftRemove, int rightRemove) {
        if (idx == seq.length) {
            if (leftRemove == 0 && rightRemove == 0)
                ans.add(path.toString());
            return;
        }

        char ch = seq[idx];
        if (ch == '(' && leftRemove > 0)
            dfs(idx + 1, leftCount, rightCount, leftRemove - 1, rightRemove);
        if (ch == ')' && rightRemove > 0)
            dfs(idx + 1, leftCount, rightCount, leftRemove, rightRemove - 1);

        path.append(ch);
        if (ch != '(' && ch != ')')
            dfs(idx + 1, leftCount, rightCount, leftRemove, rightRemove);
        else if (ch == '(')
            dfs(idx + 1, leftCount + 1, rightCount, leftRemove, rightRemove);
        else if (rightCount < leftCount)
            dfs(idx + 1, leftCount, rightCount + 1, leftRemove, rightRemove);
        path.deleteCharAt(path.length() - 1);
    }
}
