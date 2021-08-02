package DivideConquer._0241_Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression.toCharArray(), 0, expression.length() - 1);
    }

    private List<Integer> dfs(char[] arr, int l, int r) {
        List<Integer> ans = new ArrayList<>();
        int num = 0;
        for (int i = l; i <= r; i++) {
            num = num * 10 + arr[i] - '0';
            if (Character.isDigit(arr[i])) continue;
            List<Integer> left = dfs(arr, l, i - 1);
            List<Integer> right = dfs(arr, i + 1, r);
            for (int a : left) {
                for (int b : right) {
                    if (arr[i] == '-')
                        ans.add(a - b);
                    else if (arr[i] == '+')
                        ans.add(a + b);
                    else if (arr[i] == '*')
                        ans.add(a * b);
                }
            }
        }
        if (ans.isEmpty()) ans.add(num);
        return ans;
    }
}
