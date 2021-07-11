package Contest._5792_Count_Square_Sum_Triples;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countTriples(int n) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i * i, i);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map.containsKey(i * i + j * j)) ans++;
            }
        }
        return ans;
    }
}
