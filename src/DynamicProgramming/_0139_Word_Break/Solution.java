package DynamicProgramming._0139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict.size());
        int maxWordLen = 0;
        for (String word : wordDict) {
            set.add(word);
            maxWordLen = Math.max(maxWordLen, word.length());
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = (i > maxWordLen ? i - maxWordLen : 0); j < i; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
