package _0765_Partition_Labels;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hash[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = -1, right = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (i == right) {
                ans.add(i - left);
                left = i;
            }
        }
        return ans;
    }
}
