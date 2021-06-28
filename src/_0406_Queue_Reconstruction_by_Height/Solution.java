package _0406_Queue_Reconstruction_by_Height;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };
        Arrays.sort(people, c);
        List<int[]> arr = new LinkedList<>();
        for (int[] p : people) {
            arr.add(p[1], p);
        }
        return arr.toArray(new int[people.length][]);
    }
}
