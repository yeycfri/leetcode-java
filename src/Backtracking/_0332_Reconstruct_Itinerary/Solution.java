package Backtracking._0332_Reconstruct_Itinerary;

import java.util.*;

public class Solution {

    List<String> ans = new ArrayList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list : tickets) {
            String src = list.get(0);
            String des = list.get(1);
            Map<String, Integer> treemap = map.getOrDefault(src, new TreeMap<>());
            treemap.put(des, treemap.getOrDefault(des, 0) + 1);
            map.put(src, treemap);
        }
        ans.add("JFK");
        backtracking(tickets.size());
        return ans;
    }

    private boolean backtracking(int ticketsNum) {
        if (ans.size() == ticketsNum + 1) return true;

        String src = ans.get(ans.size() - 1);
        Map<String, Integer> treemap = map.get(src);
        if (treemap == null) return false;
        for (Map.Entry<String, Integer> entry : treemap.entrySet()) {
            if (entry.getValue() > 0) {
                ans.add(entry.getKey());
                treemap.put(entry.getKey(), entry.getValue() - 1);
                if (backtracking(ticketsNum)) return true;
                ans.remove(ans.size() - 1);
                treemap.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        System.out.println(solution.findItinerary(tickets));

        solution.ans.clear();
        solution.map.clear();
        tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(solution.findItinerary(tickets));
    }
}
