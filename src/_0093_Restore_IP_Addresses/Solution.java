package _0093_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();
    int[] seg = new int[4];

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return ans;
        backtracking(s, 0, 0);
        return ans;
    }

    private void backtracking(String s, int splitIdx, int segId) {
        if (segId == 4) {
            if (splitIdx == s.length()) {
                StringBuilder str = new StringBuilder(s.length() + 3);
                str.append(seg[0]);
                for (int i = 1; i < 4; i++) {
                    str.append('.').append(seg[i]);
                }
                ans.add(str.toString());
            }
            return;
        }
        if (splitIdx == s.length()) return;
        if (s.charAt(splitIdx) == '0') {
            seg[segId] = 0;
            backtracking(s, splitIdx + 1, segId + 1);
            return;
        }
        int num = 0;
        for (int i = splitIdx; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 0 && num <= 255) {
                seg[segId] = num;
                backtracking(s, i + 1, segId + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("010010"));
    }
}
