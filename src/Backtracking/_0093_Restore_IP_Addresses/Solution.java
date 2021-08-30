package Backtracking._0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans;
    int[] seg;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        seg = new int[4];
        backtracking(s, 0, 0);
        return ans;
    }

    private void backtracking(String s, int idx, int segId) {
        int n = s.length();
        if (segId == 4) {
            if (idx == n) {
                StringBuilder sb = new StringBuilder(n + 3);
                sb.append(seg[0]).append('.').append(seg[1]).append('.').append(seg[2]).append('.').append(seg[3]);
                ans.add(sb.toString());
            }
            return;
        }
        if (idx == n) return;
        if (s.charAt(idx) == '0') {
            seg[segId] = 0;
            backtracking(s, idx + 1, segId + 1);
            return;
        }
        int num = 0;
        for (int i = idx; i < n; i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) break;
            seg[segId] = num;
            backtracking(s, i + 1, segId + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("010010"));
    }
}
