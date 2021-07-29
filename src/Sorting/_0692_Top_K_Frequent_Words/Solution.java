package Sorting._0692_Top_K_Frequent_Words;


import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> list = new LinkedList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                int cnt1 = map.get(w1), cnt2 = map.get(w2);
                return cnt1 == cnt2 ? w1.compareTo(w2) : Integer.compare(cnt2, cnt1);
            }
        });
        return list.subList(0, k);
    }
}
