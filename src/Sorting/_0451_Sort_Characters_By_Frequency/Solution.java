package Sorting._0451_Sort_Characters_By_Frequency;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String frequencySortBucket(String s) {
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        StringBuilder[] bucket = new StringBuilder[maxFreq + 1];
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int freq = e.getValue();
            if (bucket[freq] == null)
                bucket[freq] = new StringBuilder();
            bucket[freq] = bucket[freq].append(e.getKey());
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = maxFreq; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int j = 0; j < bucket[i].length(); j++) {
                char ch = bucket[i].charAt(j);
                for (int k = 0; k < i; k++)
                    sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String frequencySort(String s) {
        int[] hash = new int[128];
        for (char c : s.toCharArray())
            hash[c]++;
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        while (sb.length() < n) {
            char ch = getMaxFreqChar(hash);
            for (int i = 0; i < hash[ch]; i++)
                sb.append(ch);
            hash[ch] = 0;
        }
        return sb.toString();
    }

    private char getMaxFreqChar(int[] hash) {
        char maxIdx = 0;
        for (char i = 1; i < hash.length; i++) {
            if (hash[i] > hash[maxIdx])
                maxIdx = i;
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
    }
}
