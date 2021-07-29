package Heap._0692_Top_K_Frequent_Words;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                int cnt1 = map.get(w1), cnt2 = map.get(w2);
                return cnt1 == cnt2 ? w2.compareTo(w1) : Integer.compare(cnt1, cnt2);
            }
        });
        for (String w : map.keySet()) {
            queue.offer(w);
            if (queue.size() > k)
                queue.poll();
        }
        List<String> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            ans.add(0, queue.poll());
        }
        return ans;
    }
}
