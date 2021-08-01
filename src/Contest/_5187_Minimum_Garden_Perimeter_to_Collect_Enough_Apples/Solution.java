package Contest._5187_Minimum_Garden_Perimeter_to_Collect_Enough_Apples;

public class Solution {
    public long minimumPerimeter(long neededApples) {
        long n = 1;
        while (2 * n * (n + 1) * (2 * n + 1) < neededApples) n++;
        return n * 8;
    }
}
